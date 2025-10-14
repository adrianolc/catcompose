package com.example.catcompose.features.list.ui

import app.cash.turbine.test
import com.example.catcompose.core.network.NetworkResult
import com.example.catcompose.core.test.TestCoroutineRule
import com.example.catcompose.features.list.repo.ListRepository
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class ListViewModelTest {
    @get:Rule
    val coroutineRule = TestCoroutineRule()

    private lateinit var viewModel: ListViewModel
    private val listRepository: ListRepository = mockk(relaxed = true)

    @Test
    fun `should show loading state`() =
        runTest {
            viewModel = ListViewModel(listRepository)

            viewModel.viewState.test {
                awaitItem() shouldBe ListViewState.Loading
            }
        }

    @Test
    fun `should load cats`() =
        runTest {
            val cats = listOf(Cat("1", "url"))
            coEvery { listRepository.getCats() } returns NetworkResult.Success(cats)

            viewModel = ListViewModel(listRepository)

            viewModel.viewState.test {
                awaitItem() shouldBe ListViewState.Loading
                awaitItem() shouldBe ListViewState.Success(cats = cats)
            }
        }

    @Test
    fun `should show error state`() =
        runTest {
            coEvery { listRepository.getCats() } returns NetworkResult.Error(Exception("Error"))

            viewModel = ListViewModel(listRepository)

            viewModel.viewState.test {
                awaitItem() shouldBe ListViewState.Loading
                awaitItem() shouldBe ListViewState.Error(message = "Error")
            }
        }
}
