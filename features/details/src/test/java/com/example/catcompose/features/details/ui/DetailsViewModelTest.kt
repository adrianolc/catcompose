package com.example.catcompose.features.details.ui

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.example.catcompose.core.network.NetworkResult
import com.example.catcompose.core.test.TestCoroutineRule
import com.example.catcompose.features.details.navigation.DetailsRoute
import com.example.catcompose.features.details.repo.Cat
import com.example.catcompose.features.details.repo.DetailsRepository
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class DetailsViewModelTest {
    @get:Rule
    val coroutineRule = TestCoroutineRule()

    private lateinit var viewModel: DetailsViewModel
    private val detailsRepository: DetailsRepository = mockk(relaxed = true)
    private val savedStateHandle: SavedStateHandle =
        mockk {
            every { get<String>(DetailsRoute.ARG_CAT_ID) } returns "1"
        }

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
            val cat = Cat(id = "1", url = "url", breed = null)
            coEvery { detailsRepository.getCat("1") } returns NetworkResult.Success(cat)

            viewModel = createViewModel()

            viewModel.viewState.test {
                skipItems(1)
                awaitItem() shouldBe DetailsViewState.Success(cat)
            }
        }

    @Test
    fun `should show error state`() =
        runTest {
            coEvery { detailsRepository.getCat("1") } returns NetworkResult.Error(Exception("Error"))

            viewModel = createViewModel()

            viewModel.viewState.test {
                skipItems(1)
                awaitItem() shouldBe DetailsViewState.Error(message = "Error")
            }
        }

    private fun createViewModel(): DetailsViewModel = DetailsViewModel(detailsRepository, savedStateHandle)
}
