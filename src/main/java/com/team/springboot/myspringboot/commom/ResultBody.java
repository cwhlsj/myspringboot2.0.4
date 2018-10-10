package com.team.springboot.myspringboot.commom;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ResultBody {
    public static final int SUCCESS = 1;
    public static final int FAIL = 0;

    private int code;
    private Object data;

    public ResultBody() {
    }

    public ResultBody(int code) {
        this.code = code;
    }

    public ResultBody(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static ResultBody success() {
        return new ResultBody(SUCCESS);
    }

    public static ResultBody success(Object data) {
        return new ResultBody(SUCCESS, data);
    }

    public static ResultBody success(int code, Object data) {
        if (code <= FAIL) code = SUCCESS;
        return new ResultBody(code, data);
    }

    public static ResultBody fail() {
        return new ResultBody(FAIL);
    }

    public static ResultBody fail(Object data) {
        return new ResultBody(FAIL, data);
    }

    public static ResultBody fail(String message) {
        return new ResultBody(FAIL, ErrorData.error(message));
    }

    public static ResultBody fail(int code, String message) {
        return new ResultBody(code, ErrorData.error(message));
    }

    public static ResultBody error(String message) {
        return new ResultBody(FAIL, ErrorData.error(message));
    }

    public static ResultBody page(Integer total, Integer pageIndex, Integer pageSize, List<Object> list) {
        return new ResultBody(SUCCESS, new PageData(total, pageIndex, pageSize, list));
    }

    public static ResultBody pageOfEmptyList(Integer pageIndex, Integer pageSize) {
        return new ResultBody(SUCCESS, new PageData(0, pageIndex, pageSize, Collections.emptyList()));
    }

    @Data
    private static class ErrorData {
        private String requestId;
        private String message;

        public ErrorData() {
        }

        public ErrorData(String requestId, String message) {
            this.requestId = requestId;
            this.message = message;
        }

        public static ErrorData error(String message) {
            return new ErrorData("", message);
        }
    }

    @Data
    private static class PageData {
        private Integer total;
        private Integer pageIndex;
        private Integer pageSize;
        private List<Object> list;

        public PageData() {
        }

        public PageData(Integer total, Integer pageIndex, Integer pageSize, List<Object> list) {
            this.total = total;
            this.pageIndex = pageIndex;
            this.pageSize = pageSize;
            this.list = list;
        }
    }
}
