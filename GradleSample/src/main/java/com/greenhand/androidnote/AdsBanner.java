package com.greenhand.androidnote;

import java.io.Serializable;
import java.util.List;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote
 * author: HouShengLi
 * time: 2017/4/18 10:59
 * e-mail:13967189624@163.com
 * description:
 */

public class AdsBanner implements Serializable {


    /**
     * result : 1
     * msg : 获取成功
     * data : [{"apHeight":313,"apName":"新版App_Banner","apIntro":"新版App顶部海报","apClass":2,"isUse":1,"apKey":"appbanner33","apId":26,"advList":[{"resUrl":"/upload/img/ag/1491702598104-904872.jpg","startDate":1481782347000,"sort":0,"endDate":1520570981000,"apId":26,"endDateStr":"2018-03-09 12:49:41","startDateStr":"2016-12-15 14:12:27","operationType":2,"advId":60,"advUrl":"http://www.acggou.com/product/detail?id=10445","advTitle":"凌波丽","operationContent":"10445"},{"resUrl":"/upload/img/ag/1491813132141-704379.jpg","startDate":1480666759000,"sort":0,"endDate":1496045961000,"apId":26,"endDateStr":"2017-05-29 16:19:21","startDateStr":"2016-12-02 16:19:19","operationType":2,"advId":61,"advUrl":"10455","advTitle":"神崎兰子","operationContent":"10455"},{"resUrl":"/upload/img/ag/1491901287054-831973.jpg","startDate":1481622645000,"sort":0,"endDate":1498816246000,"apId":26,"endDateStr":"2017-06-30 17:50:46","startDateStr":"2016-12-13 17:50:45","operationType":2,"advId":63,"advUrl":"http://www.acggou.com/product/detail?id=3400","advTitle":"蕾姆","operationContent":"3400"},{"resUrl":"/upload/img/ag/1490603238028-334300.jpg","startDate":1483696800000,"sort":255,"endDate":1496133102000,"apId":26,"endDateStr":"2017-05-30 16:31:42","startDateStr":"2017-01-06 18:00:00","operationType":2,"advId":68,"advUrl":"http://www.acggou.com/product/detail?id=10421","advTitle":"Vsinger Live 洛天依2017全息演唱会","operationContent":"10421"},{"resUrl":"/upload/img/ag/1492153794087-524547.jpg","startDate":1486634365000,"sort":10464,"endDate":1494323969000,"apId":26,"endDateStr":"2017-05-09 17:59:29","startDateStr":"2017-02-09 17:59:25","operationType":2,"advId":62,"advUrl":"http://www.acggou.com/product/detail?id=10464","advTitle":"aqua","operationContent":"10464"}],"apWidth":750}]
     */

    private int result;
    private String msg;
    private List<DataBean> data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * apHeight : 313
         * apName : 新版App_Banner
         * apIntro : 新版App顶部海报
         * apClass : 2
         * isUse : 1
         * apKey : appbanner33
         * apId : 26
         * advList : [{"resUrl":"/upload/img/ag/1491702598104-904872.jpg","startDate":1481782347000,"sort":0,"endDate":1520570981000,"apId":26,"endDateStr":"2018-03-09 12:49:41","startDateStr":"2016-12-15 14:12:27","operationType":2,"advId":60,"advUrl":"http://www.acggou.com/product/detail?id=10445","advTitle":"凌波丽","operationContent":"10445"},{"resUrl":"/upload/img/ag/1491813132141-704379.jpg","startDate":1480666759000,"sort":0,"endDate":1496045961000,"apId":26,"endDateStr":"2017-05-29 16:19:21","startDateStr":"2016-12-02 16:19:19","operationType":2,"advId":61,"advUrl":"10455","advTitle":"神崎兰子","operationContent":"10455"},{"resUrl":"/upload/img/ag/1491901287054-831973.jpg","startDate":1481622645000,"sort":0,"endDate":1498816246000,"apId":26,"endDateStr":"2017-06-30 17:50:46","startDateStr":"2016-12-13 17:50:45","operationType":2,"advId":63,"advUrl":"http://www.acggou.com/product/detail?id=3400","advTitle":"蕾姆","operationContent":"3400"},{"resUrl":"/upload/img/ag/1490603238028-334300.jpg","startDate":1483696800000,"sort":255,"endDate":1496133102000,"apId":26,"endDateStr":"2017-05-30 16:31:42","startDateStr":"2017-01-06 18:00:00","operationType":2,"advId":68,"advUrl":"http://www.acggou.com/product/detail?id=10421","advTitle":"Vsinger Live 洛天依2017全息演唱会","operationContent":"10421"},{"resUrl":"/upload/img/ag/1492153794087-524547.jpg","startDate":1486634365000,"sort":10464,"endDate":1494323969000,"apId":26,"endDateStr":"2017-05-09 17:59:29","startDateStr":"2017-02-09 17:59:25","operationType":2,"advId":62,"advUrl":"http://www.acggou.com/product/detail?id=10464","advTitle":"aqua","operationContent":"10464"}]
         * apWidth : 750
         */

        private int apHeight;
        private String apName;
        private String apIntro;
        private int apClass;
        private int isUse;
        private String apKey;
        private int apId;
        private int apWidth;
        private List<AdvListBean> advList;

        public int getApHeight() {
            return apHeight;
        }

        public void setApHeight(int apHeight) {
            this.apHeight = apHeight;
        }

        public String getApName() {
            return apName;
        }

        public void setApName(String apName) {
            this.apName = apName;
        }

        public String getApIntro() {
            return apIntro;
        }

        public void setApIntro(String apIntro) {
            this.apIntro = apIntro;
        }

        public int getApClass() {
            return apClass;
        }

        public void setApClass(int apClass) {
            this.apClass = apClass;
        }

        public int getIsUse() {
            return isUse;
        }

        public void setIsUse(int isUse) {
            this.isUse = isUse;
        }

        public String getApKey() {
            return apKey;
        }

        public void setApKey(String apKey) {
            this.apKey = apKey;
        }

        public int getApId() {
            return apId;
        }

        public void setApId(int apId) {
            this.apId = apId;
        }

        public int getApWidth() {
            return apWidth;
        }

        public void setApWidth(int apWidth) {
            this.apWidth = apWidth;
        }

        public List<AdvListBean> getAdvList() {
            return advList;
        }

        public void setAdvList(List<AdvListBean> advList) {
            this.advList = advList;
        }

        public static class AdvListBean {
            /**
             * resUrl : /upload/img/ag/1491702598104-904872.jpg
             * startDate : 1481782347000
             * sort : 0
             * endDate : 1520570981000
             * apId : 26
             * endDateStr : 2018-03-09 12:49:41
             * startDateStr : 2016-12-15 14:12:27
             * operationType : 2
             * advId : 60
             * advUrl : http://www.acggou.com/product/detail?id=10445
             * advTitle : 凌波丽
             * operationContent : 10445
             */

            private String resUrl;
            private long startDate;
            private int sort;
            private long endDate;
            private int apId;
            private String endDateStr;
            private String startDateStr;
            private int operationType;
            private int advId;
            private String advUrl;
            private String advTitle;
            private String operationContent;

            public String getResUrl() {
                return resUrl;
            }

            public void setResUrl(String resUrl) {
                this.resUrl = resUrl;
            }

            public long getStartDate() {
                return startDate;
            }

            public void setStartDate(long startDate) {
                this.startDate = startDate;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public long getEndDate() {
                return endDate;
            }

            public void setEndDate(long endDate) {
                this.endDate = endDate;
            }

            public int getApId() {
                return apId;
            }

            public void setApId(int apId) {
                this.apId = apId;
            }

            public String getEndDateStr() {
                return endDateStr;
            }

            public void setEndDateStr(String endDateStr) {
                this.endDateStr = endDateStr;
            }

            public String getStartDateStr() {
                return startDateStr;
            }

            public void setStartDateStr(String startDateStr) {
                this.startDateStr = startDateStr;
            }

            public int getOperationType() {
                return operationType;
            }

            public void setOperationType(int operationType) {
                this.operationType = operationType;
            }

            public int getAdvId() {
                return advId;
            }

            public void setAdvId(int advId) {
                this.advId = advId;
            }

            public String getAdvUrl() {
                return advUrl;
            }

            public void setAdvUrl(String advUrl) {
                this.advUrl = advUrl;
            }

            public String getAdvTitle() {
                return advTitle;
            }

            public void setAdvTitle(String advTitle) {
                this.advTitle = advTitle;
            }

            public String getOperationContent() {
                return operationContent;
            }

            public void setOperationContent(String operationContent) {
                this.operationContent = operationContent;
            }
        }
    }
}
