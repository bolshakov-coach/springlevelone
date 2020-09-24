package pro.bolshakov.geekbrains.springlevelone.lesson07.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pro.bolshakov.geekbrains.springlevelone.lesson07.dao.ProductDao;
import pro.bolshakov.geekbrains.springlevelone.lesson07.domain.Product;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {ProductController.class})
@WebMvcTest
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductDao productDao;

    @Test
    public void checkGetAll() throws Exception {
        //have

        Product product1 = new Product(1L, "Milk", 100.0);
        Product product2 = new Product(2L, "Beer", 450.0);

        List<Product> list = Arrays.asList(product1, product2);

        given(productDao.findAll()).willReturn(list);

        //execute
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products")
                .contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("Milk")))
                .andExpect(jsonPath("$[0].price", is(100.0)))
                .andExpect(jsonPath("$[1].title", is("Beer")));

    }

}