package com.greenhand.androidnote.info;

import java.io.Serializable;
import java.util.List;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote
 * author: HouShengLi
 * time: 2017/4/19 10:52
 * e-mail:13967189624@163.com
 * description:
 */

public class TabBean implements Serializable {


    /**
     * result : 1
     * data : [{"menuPic":"/upload/img/store/slide/1478766032848.png","sort":1,"onClickOptContent":"newgoods","menuPicUncheck":"","searchType":"gcIdSearch","onClickOptType":7,"menuName":"新品推荐"},{"menuPic":"/upload/img/store/slide/1478766068500.png","sort":2,"onClickOptContent":"1","menuPicUncheck":"","searchType":"saleType","onClickOptType":6,"menuName":"手办预定"},{"menuPic":"/upload/img/store/slide/1478766095290.png","sort":3,"onClickOptContent":"0","menuPicUncheck":"","searchType":"saleType","onClickOptType":6,"menuName":"现货优选"},{"menuPic":"/upload/img/store/slide/1478766110128.png","sort":4,"onClickOptContent":"hot","menuPicUncheck":"","searchType":"gcIdSearch","onClickOptType":7,"menuName":"热卖"}]
     * msg : 操作成功
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

    public static class DataBean implements Serializable {
        /**
         * menuPic : /upload/img/store/slide/1478766032848.png
         * sort : 1
         * onClickOptContent : newgoods
         * menuPicUncheck :
         * searchType : gcIdSearch
         * onClickOptType : 7
         * menuName : 新品推荐
         */

        private String menuPic;
        private int sort;
        private String onClickOptContent;
        private String menuPicUncheck;
        private String searchType;
        private int onClickOptType;
        private String menuName;

        public String getMenuPic() {
            return menuPic;
        }

        public void setMenuPic(String menuPic) {
            this.menuPic = menuPic;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getOnClickOptContent() {
            return onClickOptContent;
        }

        public void setOnClickOptContent(String onClickOptContent) {
            this.onClickOptContent = onClickOptContent;
        }

        public String getMenuPicUncheck() {
            return menuPicUncheck;
        }

        public void setMenuPicUncheck(String menuPicUncheck) {
            this.menuPicUncheck = menuPicUncheck;
        }

        public String getSearchType() {
            return searchType;
        }

        public void setSearchType(String searchType) {
            this.searchType = searchType;
        }

        public int getOnClickOptType() {
            return onClickOptType;
        }

        public void setOnClickOptType(int onClickOptType) {
            this.onClickOptType = onClickOptType;
        }

        public String getMenuName() {
            return menuName;
        }

        public void setMenuName(String menuName) {
            this.menuName = menuName;
        }
    }
}
