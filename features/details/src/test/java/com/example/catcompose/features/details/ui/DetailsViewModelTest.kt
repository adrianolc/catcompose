package com.example.catcompose.features.details.ui

import app.cash.turbine.test
import com.example.catcompose.core.network.NetworkResult
import com.example.catcompose.core.test.TestCoroutineRule
import com.example.catcompose.features.details.model.Cat
import com.example.catcompose.features.details.repo.DetailsRepository
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class DetailsViewModelTest {
    @get:Rule
    val coroutineRule = TestCoroutineRule()

    private lateinit var viewModel: DetailsViewModel
    private val detailsRepository: DetailsRepository = mockk(relaxed = true)
    private val catId = "1"

    @Test
    fun `should show loading state`() =
        runTest {
            viewModel = createViewModel()

            viewModel.viewState.test {
                awaitItem() shouldBe DetailsViewState.Loading
            }
        }

    @Test
    fun `should load cat details`() =
        runTest {
            val cat = Cat(id = catId, url = "url", breed = null)
            coEvery { detailsRepository.getCat(catId) } returns NetworkResult.Success(cat)

            viewModel = createViewModel()

            viewModel.viewState.test {
                skipItems(1)
                awaitItem() shouldBe DetailsViewState.Success(cat)
            }
        }

    @Test
    fun `should show error state`() =
        runTest {
            coEvery { detailsRepository.getCat(catId) } returns NetworkResult.Error(Exception("Error"))

            viewModel = createViewModel()

            viewModel.viewState.test {
                skipItems(1)
                awaitItem() shouldBe DetailsViewState.Error(message = "Error")
            }
        }

    private fun createViewModel(): DetailsViewModel = DetailsViewModel(catId = catId, detailsRepository = detailsRepository)
}
