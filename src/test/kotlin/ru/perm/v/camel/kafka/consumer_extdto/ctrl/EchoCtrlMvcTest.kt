package ru.perm.v.camel.kafka.consumer_extdto.ctrl

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@WebMvcTest(EchoCtrl::class)
class EchoCtrlMvcTest {
    @Autowired
    lateinit private var mockMvc: MockMvc

    @Test
    fun echo() {
        val mes = mockMvc.perform(get("/echo/ECHO_MESSAGE"))
            .andExpect(status().isOk)
            .andReturn()

        assertEquals("ECHO_MESSAGE", mes.response.contentAsString)
    }

}