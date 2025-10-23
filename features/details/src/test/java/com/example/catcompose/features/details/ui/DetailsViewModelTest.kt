package com.example.catcompose.features.details.ui

import app.cash.turbine.test
import com.example.catcompose.core.network.NetworkResult
import com.example.catcompose.core.test.TestCoroutineRule
import com.example.catcompose.features.details.model.Cat
import com.example.catcompose.features.details.navigation.DetailsRoute
import com.example.catcompose.features.details.repo.DetailsRepository
import io.kotest.matchers.equals.shouldBeEqual
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
                awaitItem().isLoading shouldBe true
            }
        }

    @Test
    fun `should load cat details`() =
        runTest {
            val cat = Cat(id = catId, imageUrl = "url", name = "cat", breed = null)
            coEvery { detailsRepository.getCat(catId) } returns NetworkResult.Success(cat)

            viewModel = createViewModel()

            viewModel.viewState.test {
                skipItems(1)
                awaitItem() shouldBeEqual DetailsViewState(cat = cat, isLoading = false)
            }
        }

    @Test
    fun `should show error state`() =
        runTest {
            val expectedError = Exception("Error")
            coEvery { detailsRepository.getCat(catId) } returns NetworkResult.Error(expectedError)

            viewModel = createViewModel()

            viewModel.viewState.test {
                skipItems(1)
                awaitItem().error shouldBe expectedError.message
            }
        }

    private fun createViewModel(): DetailsViewModel =
        DetailsViewModel(
            detailsRoute = DetailsRoute(catId, "url", "name"),
            detailsRepository = detailsRepository,
        )
}
