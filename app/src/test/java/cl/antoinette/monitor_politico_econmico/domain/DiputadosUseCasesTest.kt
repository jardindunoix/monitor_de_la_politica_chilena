package cl.antoinette.monitor_politico_econmico.domain

import cl.antoinette.monitor_politico_econmico.data.DiputadosRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DiputadosUseCasesTest {

   @RelaxedMockK // if I dont define the class's answer it is automaticaclty created
//   @MockK // requires all prepared
   private lateinit var repository: DiputadosRepository
   private lateinit var dipUseCase: DiputadosUseCases

   @Before   //antes del test
   fun onBefore() {
      // initializations
      MockKAnnotations.init(this)
      dipUseCase = DiputadosUseCases(repository)
   }

   @Test
   fun `when the network doesnt return the list is empty then use database instead`(): Unit = runBlocking {
//GIVEN
      coEvery { repository.getDiputadosFromWebScrap() } returns emptyList()
//WHEN
      dipUseCase()
//THEN
      coVerify(exactly = 1) { repository.getDiputadosFromDatabase() }

   }


   @Test
   fun `when database return somthing then the webscrap is not used`(): Unit = runBlocking {
//GIVEN

//WHEN

//THEN


   }
}