package com.greenhand.androidnote.info;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote.info
 * author: HouShengLi
 * time: 2017/4/21 15:59
 * e-mail:13967189624@163.com
 * description:
 */

public class DetilsInfo implements Serializable {


    /**
     * result : 1
     * msg : 获取成功
     * data : [{"goodsSpec":[{"goodsSpecId":29360,"specValueIdStr":"492","specGoodsStorage":"999","specGoodsPrice":"810.00","specGoodsDepositPrice":100}],"evaluate":3,"goodsId":10445,"goodsTransfeeCharge":1,"goodsDepositPrice":100,"cartCount":0,"salenum":0,"cityName":"广州市","goodsPayType":4,"brandName":"请选择","goodsState":0,"prepareDownTime":"2017-05-05 00:00:00","commentnum":0,"goodsTotalStorage":999,"goodsStorePrice":810,"buyButtonText":"","goodsStorePriceInterval":"810","goodsDepositPriceInterval":"100","storeName":"平台自营","isFav":0,"mansongVos":[],"worksName":"","goodsSummary":"","isUsedPopular":0,"storeLabel":"/upload/img/store/slide/1449551896807.png","evaluateStore":{"sevalServicecredit":4.9,"averageCredits":4.81,"isDel":0,"sevalDeliverycredit":4.7,"sevalDesccredit":4.9},"specOpen":1,"goodsShow":1,"promotionClass":"","goodsSpecValueAll":{"29":[{"spValueName":"港版（大几率保单）","spId":29,"spValueId":492}]},"specName":{"29":"版本"},"popular":1000,"goodsDescription":"","goodsCallyList":["/upload/img/store/0/1491445746691.jpg"],"goodsSubtitle":"ヱヴァンゲリヲン新劇場版 アヤナミレイ(仮称) 完成品フィギュア","storeId":0,"goodsName":"【预定】新世纪福音战士 eva 凌波丽（假称）  完成品 手办"}]
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
         * goodsSpec : [{"goodsSpecId":29360,"specValueIdStr":"492","specGoodsStorage":"999","specGoodsPrice":"810.00","specGoodsDepositPrice":100}]
         * evaluate : 3
         * goodsId : 10445
         * goodsTransfeeCharge : 1
         * goodsDepositPrice : 100
         * cartCount : 0
         * salenum : 0
         * cityName : 广州市
         * goodsPayType : 4
         * brandName : 请选择
         * goodsState : 0
         * prepareDownTime : 2017-05-05 00:00:00
         * commentnum : 0
         * goodsTotalStorage : 999
         * goodsStorePrice : 810
         * buyButtonText :
         * goodsStorePriceInterval : 810
         * goodsDepositPriceInterval : 100
         * storeName : 平台自营
         * isFav : 0
         * mansongVos : []
         * worksName :
         * goodsSummary :
         * isUsedPopular : 0
         * storeLabel : /upload/img/store/slide/1449551896807.png
         * evaluateStore : {"sevalServicecredit":4.9,"averageCredits":4.81,"isDel":0,"sevalDeliverycredit":4.7,"sevalDesccredit":4.9}
         * specOpen : 1
         * goodsShow : 1
         * promotionClass :
         * goodsSpecValueAll : {"29":[{"spValueName":"港版（大几率保单）","spId":29,"spValueId":492}]}
         * specName : {"29":"版本"}
         * popular : 1000
         * goodsDescription :
         * goodsCallyList : ["/upload/img/store/0/1491445746691.jpg"]
         * goodsSubtitle : ヱヴァンゲリヲン新劇場版 アヤナミレイ(仮称) 完成品フィギュア
         * storeId : 0
         * goodsName : 【预定】新世纪福音战士 eva 凌波丽（假称）  完成品 手办
         */

        private int evaluate;
        private int goodsId;
        private int goodsTransfeeCharge;
        private int goodsDepositPrice;
        private int cartCount;
        private int salenum;
        private String cityName;
        private int goodsPayType;
        private String brandName;
        private int goodsState;
        private String prepareDownTime;
        private int commentnum;
        private int goodsTotalStorage;
        private int goodsStorePrice;
        private String buyButtonText;
        private String goodsStorePriceInterval;
        private String goodsDepositPriceInterval;
        private String storeName;
        private int isFav;
        private String worksName;
        private String goodsSummary;
        private int isUsedPopular;
        private String storeLabel;
        private EvaluateStoreBean evaluateStore;
        private int specOpen;
        private int goodsShow;
        private String promotionClass;
        private GoodsSpecValueAllBean goodsSpecValueAll;
        private SpecNameBean specName;
        private int popular;
        private String goodsDescription;
        private String goodsSubtitle;
        private int storeId;
        private String goodsName;
        private List<GoodsSpecBean> goodsSpec;
        private List<?> mansongVos;
        private List<String> goodsCallyList;

        public int getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(int evaluate) {
            this.evaluate = evaluate;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public int getGoodsTransfeeCharge() {
            return goodsTransfeeCharge;
        }

        public void setGoodsTransfeeCharge(int goodsTransfeeCharge) {
            this.goodsTransfeeCharge = goodsTransfeeCharge;
        }

        public int getGoodsDepositPrice() {
            return goodsDepositPrice;
        }

        public void setGoodsDepositPrice(int goodsDepositPrice) {
            this.goodsDepositPrice = goodsDepositPrice;
        }

        public int getCartCount() {
            return cartCount;
        }

        public void setCartCount(int cartCount) {
            this.cartCount = cartCount;
        }

        public int getSalenum() {
            return salenum;
        }

        public void setSalenum(int salenum) {
            this.salenum = salenum;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public int getGoodsPayType() {
            return goodsPayType;
        }

        public void setGoodsPayType(int goodsPayType) {
            this.goodsPayType = goodsPayType;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public int getGoodsState() {
            return goodsState;
        }

        public void setGoodsState(int goodsState) {
            this.goodsState = goodsState;
        }

        public String getPrepareDownTime() {
            return prepareDownTime;
        }

        public void setPrepareDownTime(String prepareDownTime) {
            this.prepareDownTime = prepareDownTime;
        }

        public int getCommentnum() {
            return commentnum;
        }

        public void setCommentnum(int commentnum) {
            this.commentnum = commentnum;
        }

        public int getGoodsTotalStorage() {
            return goodsTotalStorage;
        }

        public void setGoodsTotalStorage(int goodsTotalStorage) {
            this.goodsTotalStorage = goodsTotalStorage;
        }

        public int getGoodsStorePrice() {
            return goodsStorePrice;
        }

        public void setGoodsStorePrice(int goodsStorePrice) {
            this.goodsStorePrice = goodsStorePrice;
        }

        public String getBuyButtonText() {
            return buyButtonText;
        }

        public void setBuyButtonText(String buyButtonText) {
            this.buyButtonText = buyButtonText;
        }

        public String getGoodsStorePriceInterval() {
            return goodsStorePriceInterval;
        }

        public void setGoodsStorePriceInterval(String goodsStorePriceInterval) {
            this.goodsStorePriceInterval = goodsStorePriceInterval;
        }

        public String getGoodsDepositPriceInterval() {
            return goodsDepositPriceInterval;
        }

        public void setGoodsDepositPriceInterval(String goodsDepositPriceInterval) {
            this.goodsDepositPriceInterval = goodsDepositPriceInterval;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public int getIsFav() {
            return isFav;
        }

        public void setIsFav(int isFav) {
            this.isFav = isFav;
        }

        public String getWorksName() {
            return worksName;
        }

        public void setWorksName(String worksName) {
            this.worksName = worksName;
        }

        public String getGoodsSummary() {
            return goodsSummary;
        }

        public void setGoodsSummary(String goodsSummary) {
            this.goodsSummary = goodsSummary;
        }

        public int getIsUsedPopular() {
            return isUsedPopular;
        }

        public void setIsUsedPopular(int isUsedPopular) {
            this.isUsedPopular = isUsedPopular;
        }

        public String getStoreLabel() {
            return storeLabel;
        }

        public void setStoreLabel(String storeLabel) {
            this.storeLabel = storeLabel;
        }

        public EvaluateStoreBean getEvaluateStore() {
            return evaluateStore;
        }

        public void setEvaluateStore(EvaluateStoreBean evaluateStore) {
            this.evaluateStore = evaluateStore;
        }

        public int getSpecOpen() {
            return specOpen;
        }

        public void setSpecOpen(int specOpen) {
            this.specOpen = specOpen;
        }

        public int getGoodsShow() {
            return goodsShow;
        }

        public void setGoodsShow(int goodsShow) {
            this.goodsShow = goodsShow;
        }

        public String getPromotionClass() {
            return promotionClass;
        }

        public void setPromotionClass(String promotionClass) {
            this.promotionClass = promotionClass;
        }

        public GoodsSpecValueAllBean getGoodsSpecValueAll() {
            return goodsSpecValueAll;
        }

        public void setGoodsSpecValueAll(GoodsSpecValueAllBean goodsSpecValueAll) {
            this.goodsSpecValueAll = goodsSpecValueAll;
        }

        public SpecNameBean getSpecName() {
            return specName;
        }

        public void setSpecName(SpecNameBean specName) {
            this.specName = specName;
        }

        public int getPopular() {
            return popular;
        }

        public void setPopular(int popular) {
            this.popular = popular;
        }

        public String getGoodsDescription() {
            return goodsDescription;
        }

        public void setGoodsDescription(String goodsDescription) {
            this.goodsDescription = goodsDescription;
        }

        public String getGoodsSubtitle() {
            return goodsSubtitle;
        }

        public void setGoodsSubtitle(String goodsSubtitle) {
            this.goodsSubtitle = goodsSubtitle;
        }

        public int getStoreId() {
            return storeId;
        }

        public void setStoreId(int storeId) {
            this.storeId = storeId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public List<GoodsSpecBean> getGoodsSpec() {
            return goodsSpec;
        }

        public void setGoodsSpec(List<GoodsSpecBean> goodsSpec) {
            this.goodsSpec = goodsSpec;
        }

        public List<?> getMansongVos() {
            return mansongVos;
        }

        public void setMansongVos(List<?> mansongVos) {
            this.mansongVos = mansongVos;
        }

        public List<String> getGoodsCallyList() {
            return goodsCallyList;
        }

        public void setGoodsCallyList(List<String> goodsCallyList) {
            this.goodsCallyList = goodsCallyList;
        }

        public static class EvaluateStoreBean {
            /**
             * sevalServicecredit : 4.9
             * averageCredits : 4.81
             * isDel : 0
             * sevalDeliverycredit : 4.7
             * sevalDesccredit : 4.9
             */

            private double sevalServicecredit;
            private double averageCredits;
            private int isDel;
            private double sevalDeliverycredit;
            private double sevalDesccredit;

            public double getSevalServicecredit() {
                return sevalServicecredit;
            }

            public void setSevalServicecredit(double sevalServicecredit) {
                this.sevalServicecredit = sevalServicecredit;
            }

            public double getAverageCredits() {
                return averageCredits;
            }

            public void setAverageCredits(double averageCredits) {
                this.averageCredits = averageCredits;
            }

            public int getIsDel() {
                return isDel;
            }

            public void setIsDel(int isDel) {
                this.isDel = isDel;
            }

            public double getSevalDeliverycredit() {
                return sevalDeliverycredit;
            }

            public void setSevalDeliverycredit(double sevalDeliverycredit) {
                this.sevalDeliverycredit = sevalDeliverycredit;
            }

            public double getSevalDesccredit() {
                return sevalDesccredit;
            }

            public void setSevalDesccredit(double sevalDesccredit) {
                this.sevalDesccredit = sevalDesccredit;
            }
        }

        public static class GoodsSpecValueAllBean {
            @JSONField(name = "29")
            private List<_$29Bean> _$29;

            public List<_$29Bean> get_$29() {
                return _$29;
            }

            public void set_$29(List<_$29Bean> _$29) {
                this._$29 = _$29;
            }

            public static class _$29Bean {
                /**
                 * spValueName : 港版（大几率保单）
                 * spId : 29
                 * spValueId : 492
                 */

                private String spValueName;
                private int spId;
                private int spValueId;

                public String getSpValueName() {
                    return spValueName;
                }

                public void setSpValueName(String spValueName) {
                    this.spValueName = spValueName;
                }

                public int getSpId() {
                    return spId;
                }

                public void setSpId(int spId) {
                    this.spId = spId;
                }

                public int getSpValueId() {
                    return spValueId;
                }

                public void setSpValueId(int spValueId) {
                    this.spValueId = spValueId;
                }
            }
        }

        public static class SpecNameBean {
            /**
             * 29 : 版本
             */

            @JSONField(name = "29")
            private String _$29;

            public String get_$29() {
                return _$29;
            }

            public void set_$29(String _$29) {
                this._$29 = _$29;
            }
        }

        public static class GoodsSpecBean implements Serializable {
            /**
             * goodsSpecId : 29360
             * specValueIdStr : 492
             * specGoodsStorage : 999
             * specGoodsPrice : 810.00
             * specGoodsDepositPrice : 100
             */

            private int goodsSpecId;
            private String specValueIdStr;
            private String specGoodsStorage;
            private String specGoodsPrice;
            private int specGoodsDepositPrice;

            public int getGoodsSpecId() {
                return goodsSpecId;
            }

            public void setGoodsSpecId(int goodsSpecId) {
                this.goodsSpecId = goodsSpecId;
            }

            public String getSpecValueIdStr() {
                return specValueIdStr;
            }

            public void setSpecValueIdStr(String specValueIdStr) {
                this.specValueIdStr = specValueIdStr;
            }

            public String getSpecGoodsStorage() {
                return specGoodsStorage;
            }

            public void setSpecGoodsStorage(String specGoodsStorage) {
                this.specGoodsStorage = specGoodsStorage;
            }

            public String getSpecGoodsPrice() {
                return specGoodsPrice;
            }

            public void setSpecGoodsPrice(String specGoodsPrice) {
                this.specGoodsPrice = specGoodsPrice;
            }

            public int getSpecGoodsDepositPrice() {
                return specGoodsDepositPrice;
            }

            public void setSpecGoodsDepositPrice(int specGoodsDepositPrice) {
                this.specGoodsDepositPrice = specGoodsDepositPrice;
            }
        }
    }
}
