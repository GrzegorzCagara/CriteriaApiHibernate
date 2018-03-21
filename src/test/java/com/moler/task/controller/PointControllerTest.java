package com.moler.task.controller;

import com.moler.task.dto.PointResponse;
import com.moler.task.entity.Point;
import com.moler.task.service.PointService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PointController.class, secure = false)
public class PointControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PointService pointService;

    private Point mockPoint = null;

    @Before
    public void setUp() throws Exception{
        mockPoint = new Point(1L, "punkt");
    }

    @Test
    public void shouldReturnStatus200WhenPointSaved() {

    }

    @Test
    public void getAllPoints() throws Exception {
        PointResponse mockPoints = mockItems();

        when(pointService.getAll()).thenReturn(mockPoints);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/points/get").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{status:200, data: [{id: 1, name: punkt}, {id: 2, name: punkt2}, {id: 3, name: punkt3} ] }";

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    private PointResponse mockItems(){
        Point point = new Point(1L, "punkt");
        Point point2 = new Point(2L, "punkt2");
        Point point3 = new Point(3L, "punkt3");
        List<Point> points = Arrays.asList(point, point2, point3);
//        PointResponse p = new PointResponse(200, point);
//        PointResponse p2 = new PointResponse(200, point2);
//        PointResponse p3 = new PointResponse(200, point3);
        return new PointResponse(200, points);
    }
}