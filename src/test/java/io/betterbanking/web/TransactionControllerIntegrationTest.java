package io.betterbanking.web;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import io.betterbanking.entity.Transaction;
import io.betterbanking.service.TransactionService;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private TransactionService transactionService;
	
	@Test
	public void testFindAllByAccountNumber() throws Exception {
		when(transactionService.findAllByAccountNumber(1234)).thenReturn(List.of(
                Transaction
                .builder()
                .type("credit")
                .date(new Date())
                .accountNumber(1234)
                .currency("USD")
                .amount(100.00)
                .merchantName("acme")
                .merchantLogo("images/acme-logo.png")
                .build(),
                Transaction
                .builder()
                .type("credit")
                .date(new Date())
                .accountNumber(1234)
                .currency("USD")
                .amount(1002.00)
                .merchantName("acme")
                .merchantLogo("images/acme-logo.png")
                .build()
        ));
		
		
		mockMvc.perform(get("/api/v1/transactions/1234"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$", hasSize(2)));
		
		verify(transactionService,times(1)).findAllByAccountNumber(1234);
		
	}

}
