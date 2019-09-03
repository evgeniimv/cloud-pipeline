package com.epam.pipeline.tesadapter.app;


import com.epam.pipeline.tesadapter.controller.TesAdapterController;
import com.epam.pipeline.tesadapter.entity.TesCancelTaskResponse;
import com.epam.pipeline.tesadapter.entity.TesCreateTaskResponse;
import com.epam.pipeline.tesadapter.entity.TesListTasksResponse;
import com.epam.pipeline.tesadapter.entity.TesTask;
import com.epam.pipeline.tesadapter.service.CloudPipelineAPIClient;
import com.epam.pipeline.tesadapter.service.TesTaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(TesAdapterController.class)
@SuppressWarnings({"unused", "PMD.TooManyStaticImports"})
public class TesAdapterControllerTest {
    private static final String STUBBED_TASK_ID = "5";
    private static final Long STUBBED_PAGE_SIZE = 55L;
    private static final String STUBBED_SUBMIT_JSON_REQUEST = "{}";
    private static final String STUBBED_SUBMIT_JSON_RESPONSE = "{\"id\":\"5\"}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TesTaskServiceImpl tesTaskService;

    @MockBean
    private CloudPipelineAPIClient cloudPipelineAPIClient;

    @Test
    void submitTesTaskWhenRequestingTesTaskBodyAndReturnId() throws Exception {
        TesCreateTaskResponse tesCreateTaskResponse = new TesCreateTaskResponse();
        tesCreateTaskResponse.setId(STUBBED_TASK_ID);
        when(tesTaskService.submitTesTask(any(TesTask.class))).thenReturn(tesCreateTaskResponse);
        this.mockMvc.perform(post("/v1/tasks").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(STUBBED_SUBMIT_JSON_REQUEST))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().json(STUBBED_SUBMIT_JSON_RESPONSE));
    }

    @Test
    void cancelTesTaskWhenRequestingIdReturnCanceledTask() throws Exception {
        when(tesTaskService.cancelTesTask(STUBBED_TASK_ID)).thenReturn(new TesCancelTaskResponse());
        this.mockMvc.perform(post("/v1/tasks/{id}:cancel", STUBBED_TASK_ID))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void listTesTaskWhenRequestingReturnTesListTasksResponse() throws Exception {
        when(tesTaskService.listTesTask()).thenReturn(new TesListTasksResponse());
        this.mockMvc.perform(get("/v1/tasks?page_size={size}", STUBBED_PAGE_SIZE))
                .andDo(print()).andExpect(status().isOk());
    }
}