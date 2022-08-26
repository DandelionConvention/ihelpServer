package com.services.core.bo.tencent.lbs;

import java.util.List;

public class CoordinateDetailResponseBO
{
    /**
     * status : 0
     * message : query ok
     * request_id : 4712a660-f74d-11ea-b993-52540075289e
     * result : {"location":{"lat":39.984154,"lng":116.30749},"address":"北京市海淀区北四环西路66号","formatted_addresses":{"recommend":"海淀区中关村中国技术交易大厦(彩和坊路)","rough":"海淀区中关村中国技术交易大厦(彩和坊路)"},"address_component":{"nation":"中国","province":"北京市","city":"北京市","district":"海淀区","street":"北四环西路","street_number":"北四环西路66号"},"ad_info":{"nation_code":"156","adcode":"110108","city_code":"156110000","name":"中国,北京市,北京市,海淀区","location":{"lat":40.045132,"lng":116.375},"nation":"中国","province":"北京市","city":"北京市","district":"海淀区"},"address_reference":{"business_area":{"id":"14178584199053362783","title":"中关村","location":{"lat":39.980598,"lng":116.310997},"_distance":0,"_dir_desc":"内"},"famous_area":{"id":"14178584199053362783","title":"中关村","location":{"lat":39.980598,"lng":116.310997},"_distance":0,"_dir_desc":"内"},"crossroad":{"id":"529979","title":"海淀大街/彩和坊路(路口)","location":{"lat":39.982498,"lng":116.30809},"_distance":185.8,"_dir_desc":"北"},"town":{"id":"110108012","title":"海淀街道","location":{"lat":39.974819,"lng":116.284409},"_distance":0,"_dir_desc":"内"},"street_number":{"id":"595672509379194165901290","title":"北四环西路66号","location":{"lat":39.984089,"lng":116.308037},"_distance":45.8,"_dir_desc":""},"street":{"id":"9217092216709107946","title":"彩和坊路","location":{"lat":39.97921,"lng":116.308411},"_distance":46.6,"_dir_desc":"西"},"landmark_l2":{"id":"3629720141162880123","title":"中国技术交易大厦","location":{"lat":39.984253,"lng":116.307472},"_distance":0,"_dir_desc":"内"}},"poi_count":10,"pois":[{"id":"3629720141162880123","title":"中国技术交易大厦","address":"北京市海淀区北四环西路66号","category":"房产小区:商务楼宇","location":{"lat":39.984253,"lng":116.307472},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":0,"_dir_desc":"内"},{"id":"9969038414753335812","title":"腾讯科技(北京)有限公司(中国技术交易大厦)","address":"北京市海淀区北四环西路66号中国技术交易大厦第三极大厦5-11层","category":"公司企业:公司企业","location":{"lat":39.984131,"lng":116.307503},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":0,"_dir_desc":"内"},{"id":"2845372667492951071","title":"中国技术交易大厦A座","address":"北京市海淀区北四环西路66号","category":"房产小区:商务楼宇","location":{"lat":39.984329,"lng":116.307419},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":20.4,"_dir_desc":""},{"id":"3724888736111897241","title":"万学教育集团","address":"北京市海淀区北四环西路66号中国技术交易大厦","category":"教育学校:培训","location":{"lat":39.984085,"lng":116.307426},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":9.2,"_dir_desc":""},{"id":"13477589832396847863","title":"品·咖啡","address":"北京市海淀区北四环西路66号中国技术交易大厦1楼大厅内","category":"娱乐休闲:咖啡厅","location":{"lat":39.984184,"lng":116.307335},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":13.5,"_dir_desc":""},{"id":"3187032738687555052","title":"中关村创业大街","address":"北京市海淀区海淀西大街","category":"购物:商业步行街","location":{"lat":39.983654,"lng":116.306854},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":36.3,"_dir_desc":"东北"},{"id":"12925244666643621769","title":"中国技术交易大厦B座","address":"北京市海淀区北四环西路66号","category":"房产小区:商务楼宇","location":{"lat":39.983906,"lng":116.307556},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":28.2,"_dir_desc":""},{"id":"7246616758286733108","title":"基督教堂(彩和坊路)","address":"北京市海淀区彩和坊路9号","category":"旅游景点:教堂","location":{"lat":39.983257,"lng":116.307678},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":69.5,"_dir_desc":"北"},{"id":"404948428189199472","title":"国家知识产权局专利局北京代办处","address":"北京市海淀区北四环西路66号中国技术交易大厦2层中国(北京)知识产权保护中心大厅","category":"机构团体:政府机关","location":{"lat":39.98418,"lng":116.307518},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":4,"_dir_desc":""},{"id":"12689244359326172642","title":"车库咖啡","address":"北京市海淀区中关村创业大街6号楼2层","category":"娱乐休闲:咖啡厅","location":{"lat":39.983898,"lng":116.306908},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":57.1,"_dir_desc":"东北"}]}
     */

    private Integer status;
    private String message;
    private String request_id;
    private ResultBean result;

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getRequest_id()
    {
        return request_id;
    }

    public void setRequest_id(String request_id)
    {
        this.request_id = request_id;
    }

    public ResultBean getResult()
    {
        return result;
    }

    public void setResult(ResultBean result)
    {
        this.result = result;
    }

    public static class ResultBean
    {
        /**
         * location : {"lat":39.984154,"lng":116.30749}
         * address : 北京市海淀区北四环西路66号
         * formatted_addresses : {"recommend":"海淀区中关村中国技术交易大厦(彩和坊路)","rough":"海淀区中关村中国技术交易大厦(彩和坊路)"}
         * address_component : {"nation":"中国","province":"北京市","city":"北京市","district":"海淀区","street":"北四环西路","street_number":"北四环西路66号"}
         * ad_info : {"nation_code":"156","adcode":"110108","city_code":"156110000","name":"中国,北京市,北京市,海淀区","location":{"lat":40.045132,"lng":116.375},"nation":"中国","province":"北京市","city":"北京市","district":"海淀区"}
         * address_reference : {"business_area":{"id":"14178584199053362783","title":"中关村","location":{"lat":39.980598,"lng":116.310997},"_distance":0,"_dir_desc":"内"},"famous_area":{"id":"14178584199053362783","title":"中关村","location":{"lat":39.980598,"lng":116.310997},"_distance":0,"_dir_desc":"内"},"crossroad":{"id":"529979","title":"海淀大街/彩和坊路(路口)","location":{"lat":39.982498,"lng":116.30809},"_distance":185.8,"_dir_desc":"北"},"town":{"id":"110108012","title":"海淀街道","location":{"lat":39.974819,"lng":116.284409},"_distance":0,"_dir_desc":"内"},"street_number":{"id":"595672509379194165901290","title":"北四环西路66号","location":{"lat":39.984089,"lng":116.308037},"_distance":45.8,"_dir_desc":""},"street":{"id":"9217092216709107946","title":"彩和坊路","location":{"lat":39.97921,"lng":116.308411},"_distance":46.6,"_dir_desc":"西"},"landmark_l2":{"id":"3629720141162880123","title":"中国技术交易大厦","location":{"lat":39.984253,"lng":116.307472},"_distance":0,"_dir_desc":"内"}}
         * poi_count : 10
         * pois : [{"id":"3629720141162880123","title":"中国技术交易大厦","address":"北京市海淀区北四环西路66号","category":"房产小区:商务楼宇","location":{"lat":39.984253,"lng":116.307472},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":0,"_dir_desc":"内"},{"id":"9969038414753335812","title":"腾讯科技(北京)有限公司(中国技术交易大厦)","address":"北京市海淀区北四环西路66号中国技术交易大厦第三极大厦5-11层","category":"公司企业:公司企业","location":{"lat":39.984131,"lng":116.307503},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":0,"_dir_desc":"内"},{"id":"2845372667492951071","title":"中国技术交易大厦A座","address":"北京市海淀区北四环西路66号","category":"房产小区:商务楼宇","location":{"lat":39.984329,"lng":116.307419},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":20.4,"_dir_desc":""},{"id":"3724888736111897241","title":"万学教育集团","address":"北京市海淀区北四环西路66号中国技术交易大厦","category":"教育学校:培训","location":{"lat":39.984085,"lng":116.307426},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":9.2,"_dir_desc":""},{"id":"13477589832396847863","title":"品·咖啡","address":"北京市海淀区北四环西路66号中国技术交易大厦1楼大厅内","category":"娱乐休闲:咖啡厅","location":{"lat":39.984184,"lng":116.307335},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":13.5,"_dir_desc":""},{"id":"3187032738687555052","title":"中关村创业大街","address":"北京市海淀区海淀西大街","category":"购物:商业步行街","location":{"lat":39.983654,"lng":116.306854},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":36.3,"_dir_desc":"东北"},{"id":"12925244666643621769","title":"中国技术交易大厦B座","address":"北京市海淀区北四环西路66号","category":"房产小区:商务楼宇","location":{"lat":39.983906,"lng":116.307556},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":28.2,"_dir_desc":""},{"id":"7246616758286733108","title":"基督教堂(彩和坊路)","address":"北京市海淀区彩和坊路9号","category":"旅游景点:教堂","location":{"lat":39.983257,"lng":116.307678},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":69.5,"_dir_desc":"北"},{"id":"404948428189199472","title":"国家知识产权局专利局北京代办处","address":"北京市海淀区北四环西路66号中国技术交易大厦2层中国(北京)知识产权保护中心大厅","category":"机构团体:政府机关","location":{"lat":39.98418,"lng":116.307518},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":4,"_dir_desc":""},{"id":"12689244359326172642","title":"车库咖啡","address":"北京市海淀区中关村创业大街6号楼2层","category":"娱乐休闲:咖啡厅","location":{"lat":39.983898,"lng":116.306908},"ad_info":{"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"},"_distance":57.1,"_dir_desc":"东北"}]
         */

        private LocationBean location;
        private String address;
        private FormattedAddressesBean formatted_addresses;
        private AddressComponentBean address_component;
        private AdInfoBean ad_info;
        private AddressReferenceBean address_reference;
        private Integer poi_count;
        private List<PoisBean> pois;

        public LocationBean getLocation()
        {
            return location;
        }

        public void setLocation(LocationBean location)
        {
            this.location = location;
        }

        public String getAddress()
        {
            return address;
        }

        public void setAddress(String address)
        {
            this.address = address;
        }

        public FormattedAddressesBean getFormatted_addresses()
        {
            return formatted_addresses;
        }

        public void setFormatted_addresses(FormattedAddressesBean formatted_addresses)
        {
            this.formatted_addresses = formatted_addresses;
        }

        public AddressComponentBean getAddress_component()
        {
            return address_component;
        }

        public void setAddress_component(AddressComponentBean address_component)
        {
            this.address_component = address_component;
        }

        public AdInfoBean getAd_info()
        {
            return ad_info;
        }

        public void setAd_info(AdInfoBean ad_info)
        {
            this.ad_info = ad_info;
        }

        public AddressReferenceBean getAddress_reference()
        {
            return address_reference;
        }

        public void setAddress_reference(AddressReferenceBean address_reference)
        {
            this.address_reference = address_reference;
        }

        public Integer getPoi_count()
        {
            return poi_count;
        }

        public void setPoi_count(Integer poi_count)
        {
            this.poi_count = poi_count;
        }

        public List<PoisBean> getPois()
        {
            return pois;
        }

        public void setPois(List<PoisBean> pois)
        {
            this.pois = pois;
        }

        public static class LocationBean
        {
            /**
             * lat : 39.984154
             * lng : 116.30749
             */

            private Double lat;
            private Double lng;

            public Double getLat()
            {
                return lat;
            }

            public void setLat(Double lat)
            {
                this.lat = lat;
            }

            public Double getLng()
            {
                return lng;
            }

            public void setLng(Double lng)
            {
                this.lng = lng;
            }
        }

        public static class FormattedAddressesBean
        {
            /**
             * recommend : 海淀区中关村中国技术交易大厦(彩和坊路)
             * rough : 海淀区中关村中国技术交易大厦(彩和坊路)
             */

            private String recommend;
            private String rough;

            public String getRecommend()
            {
                return recommend;
            }

            public void setRecommend(String recommend)
            {
                this.recommend = recommend;
            }

            public String getRough()
            {
                return rough;
            }

            public void setRough(String rough)
            {
                this.rough = rough;
            }
        }

        public static class AddressComponentBean
        {
            /**
             * nation : 中国
             * province : 北京市
             * city : 北京市
             * district : 海淀区
             * street : 北四环西路
             * street_number : 北四环西路66号
             */

            private String nation;
            private String province;
            private String city;
            private String district;
            private String street;
            private String street_number;

            public String getNation()
            {
                return nation;
            }

            public void setNation(String nation)
            {
                this.nation = nation;
            }

            public String getProvince()
            {
                return province;
            }

            public void setProvince(String province)
            {
                this.province = province;
            }

            public String getCity()
            {
                return city;
            }

            public void setCity(String city)
            {
                this.city = city;
            }

            public String getDistrict()
            {
                return district;
            }

            public void setDistrict(String district)
            {
                this.district = district;
            }

            public String getStreet()
            {
                return street;
            }

            public void setStreet(String street)
            {
                this.street = street;
            }

            public String getStreet_number()
            {
                return street_number;
            }

            public void setStreet_number(String street_number)
            {
                this.street_number = street_number;
            }
        }

        public static class AdInfoBean
        {
            /**
             * nation_code : 156
             * adcode : 110108
             * city_code : 156110000
             * name : 中国,北京市,北京市,海淀区
             * location : {"lat":40.045132,"lng":116.375}
             * nation : 中国
             * province : 北京市
             * city : 北京市
             * district : 海淀区
             */

            private String nation_code;
            private String adcode;
            private String city_code;
            private String name;
            private LocationBeanX location;
            private String nation;
            private String province;
            private String city;
            private String district;

            public String getNation_code()
            {
                return nation_code;
            }

            public void setNation_code(String nation_code)
            {
                this.nation_code = nation_code;
            }

            public String getAdcode()
            {
                return adcode;
            }

            public void setAdcode(String adcode)
            {
                this.adcode = adcode;
            }

            public String getCity_code()
            {
                return city_code;
            }

            public void setCity_code(String city_code)
            {
                this.city_code = city_code;
            }

            public String getName()
            {
                return name;
            }

            public void setName(String name)
            {
                this.name = name;
            }

            public LocationBeanX getLocation()
            {
                return location;
            }

            public void setLocation(LocationBeanX location)
            {
                this.location = location;
            }

            public String getNation()
            {
                return nation;
            }

            public void setNation(String nation)
            {
                this.nation = nation;
            }

            public String getProvince()
            {
                return province;
            }

            public void setProvince(String province)
            {
                this.province = province;
            }

            public String getCity()
            {
                return city;
            }

            public void setCity(String city)
            {
                this.city = city;
            }

            public String getDistrict()
            {
                return district;
            }

            public void setDistrict(String district)
            {
                this.district = district;
            }

            public static class LocationBeanX
            {
                /**
                 * lat : 40.045132
                 * lng : 116.375
                 */

                private Double lat;
                private Double lng;

                public Double getLat()
                {
                    return lat;
                }

                public void setLat(Double lat)
                {
                    this.lat = lat;
                }

                public Double getLng()
                {
                    return lng;
                }

                public void setLng(Double lng)
                {
                    this.lng = lng;
                }
            }
        }

        public static class AddressReferenceBean
        {
            /**
             * business_area : {"id":"14178584199053362783","title":"中关村","location":{"lat":39.980598,"lng":116.310997},"_distance":0,"_dir_desc":"内"}
             * famous_area : {"id":"14178584199053362783","title":"中关村","location":{"lat":39.980598,"lng":116.310997},"_distance":0,"_dir_desc":"内"}
             * crossroad : {"id":"529979","title":"海淀大街/彩和坊路(路口)","location":{"lat":39.982498,"lng":116.30809},"_distance":185.8,"_dir_desc":"北"}
             * town : {"id":"110108012","title":"海淀街道","location":{"lat":39.974819,"lng":116.284409},"_distance":0,"_dir_desc":"内"}
             * street_number : {"id":"595672509379194165901290","title":"北四环西路66号","location":{"lat":39.984089,"lng":116.308037},"_distance":45.8,"_dir_desc":""}
             * street : {"id":"9217092216709107946","title":"彩和坊路","location":{"lat":39.97921,"lng":116.308411},"_distance":46.6,"_dir_desc":"西"}
             * landmark_l2 : {"id":"3629720141162880123","title":"中国技术交易大厦","location":{"lat":39.984253,"lng":116.307472},"_distance":0,"_dir_desc":"内"}
             */

            private BusinessAreaBean business_area;
            private FamousAreaBean famous_area;
            private CrossroadBean crossroad;
            private TownBean town;
            private StreetNumberBean street_number;
            private StreetBean street;
            private LandmarkL2Bean landmark_l2;

            public BusinessAreaBean getBusiness_area()
            {
                return business_area;
            }

            public void setBusiness_area(BusinessAreaBean business_area)
            {
                this.business_area = business_area;
            }

            public FamousAreaBean getFamous_area()
            {
                return famous_area;
            }

            public void setFamous_area(FamousAreaBean famous_area)
            {
                this.famous_area = famous_area;
            }

            public CrossroadBean getCrossroad()
            {
                return crossroad;
            }

            public void setCrossroad(CrossroadBean crossroad)
            {
                this.crossroad = crossroad;
            }

            public TownBean getTown()
            {
                return town;
            }

            public void setTown(TownBean town)
            {
                this.town = town;
            }

            public StreetNumberBean getStreet_number()
            {
                return street_number;
            }

            public void setStreet_number(StreetNumberBean street_number)
            {
                this.street_number = street_number;
            }

            public StreetBean getStreet()
            {
                return street;
            }

            public void setStreet(StreetBean street)
            {
                this.street = street;
            }

            public LandmarkL2Bean getLandmark_l2()
            {
                return landmark_l2;
            }

            public void setLandmark_l2(LandmarkL2Bean landmark_l2)
            {
                this.landmark_l2 = landmark_l2;
            }

            public static class BusinessAreaBean
            {
                /**
                 * id : 14178584199053362783
                 * title : 中关村
                 * location : {"lat":39.980598,"lng":116.310997}
                 * _distance : 0
                 * _dir_desc : 内
                 */

                private String id;
                private String title;
                private LocationBeanXX location;
                private Integer _distance;
                private String _dir_desc;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public String getTitle()
                {
                    return title;
                }

                public void setTitle(String title)
                {
                    this.title = title;
                }

                public LocationBeanXX getLocation()
                {
                    return location;
                }

                public void setLocation(LocationBeanXX location)
                {
                    this.location = location;
                }

                public Integer get_distance()
                {
                    return _distance;
                }

                public void set_distance(Integer _distance)
                {
                    this._distance = _distance;
                }

                public String get_dir_desc()
                {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc)
                {
                    this._dir_desc = _dir_desc;
                }

                public static class LocationBeanXX
                {
                    /**
                     * lat : 39.980598
                     * lng : 116.310997
                     */

                    private Double lat;
                    private Double lng;

                    public Double getLat()
                    {
                        return lat;
                    }

                    public void setLat(Double lat)
                    {
                        this.lat = lat;
                    }

                    public Double getLng()
                    {
                        return lng;
                    }

                    public void setLng(Double lng)
                    {
                        this.lng = lng;
                    }
                }
            }

            public static class FamousAreaBean
            {
                /**
                 * id : 14178584199053362783
                 * title : 中关村
                 * location : {"lat":39.980598,"lng":116.310997}
                 * _distance : 0
                 * _dir_desc : 内
                 */

                private String id;
                private String title;
                private LocationBeanXXX location;
                private Integer _distance;
                private String _dir_desc;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public String getTitle()
                {
                    return title;
                }

                public void setTitle(String title)
                {
                    this.title = title;
                }

                public LocationBeanXXX getLocation()
                {
                    return location;
                }

                public void setLocation(LocationBeanXXX location)
                {
                    this.location = location;
                }

                public Integer get_distance()
                {
                    return _distance;
                }

                public void set_distance(Integer _distance)
                {
                    this._distance = _distance;
                }

                public String get_dir_desc()
                {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc)
                {
                    this._dir_desc = _dir_desc;
                }

                public static class LocationBeanXXX
                {
                    /**
                     * lat : 39.980598
                     * lng : 116.310997
                     */

                    private Double lat;
                    private Double lng;

                    public Double getLat()
                    {
                        return lat;
                    }

                    public void setLat(Double lat)
                    {
                        this.lat = lat;
                    }

                    public Double getLng()
                    {
                        return lng;
                    }

                    public void setLng(Double lng)
                    {
                        this.lng = lng;
                    }
                }
            }

            public static class CrossroadBean
            {
                /**
                 * id : 529979
                 * title : 海淀大街/彩和坊路(路口)
                 * location : {"lat":39.982498,"lng":116.30809}
                 * _distance : 185.8
                 * _dir_desc : 北
                 */

                private String id;
                private String title;
                private LocationBeanXXXX location;
                private Double _distance;
                private String _dir_desc;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public String getTitle()
                {
                    return title;
                }

                public void setTitle(String title)
                {
                    this.title = title;
                }

                public LocationBeanXXXX getLocation()
                {
                    return location;
                }

                public void setLocation(LocationBeanXXXX location)
                {
                    this.location = location;
                }

                public Double get_distance()
                {
                    return _distance;
                }

                public void set_distance(Double _distance)
                {
                    this._distance = _distance;
                }

                public String get_dir_desc()
                {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc)
                {
                    this._dir_desc = _dir_desc;
                }

                public static class LocationBeanXXXX
                {
                    /**
                     * lat : 39.982498
                     * lng : 116.30809
                     */

                    private Double lat;
                    private Double lng;

                    public Double getLat()
                    {
                        return lat;
                    }

                    public void setLat(Double lat)
                    {
                        this.lat = lat;
                    }

                    public Double getLng()
                    {
                        return lng;
                    }

                    public void setLng(Double lng)
                    {
                        this.lng = lng;
                    }
                }
            }

            public static class TownBean
            {
                /**
                 * id : 110108012
                 * title : 海淀街道
                 * location : {"lat":39.974819,"lng":116.284409}
                 * _distance : 0
                 * _dir_desc : 内
                 */

                private String id;
                private String title;
                private LocationBeanXXXXX location;
                private Integer _distance;
                private String _dir_desc;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public String getTitle()
                {
                    return title;
                }

                public void setTitle(String title)
                {
                    this.title = title;
                }

                public LocationBeanXXXXX getLocation()
                {
                    return location;
                }

                public void setLocation(LocationBeanXXXXX location)
                {
                    this.location = location;
                }

                public Integer get_distance()
                {
                    return _distance;
                }

                public void set_distance(Integer _distance)
                {
                    this._distance = _distance;
                }

                public String get_dir_desc()
                {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc)
                {
                    this._dir_desc = _dir_desc;
                }

                public static class LocationBeanXXXXX
                {
                    /**
                     * lat : 39.974819
                     * lng : 116.284409
                     */

                    private Double lat;
                    private Double lng;

                    public Double getLat()
                    {
                        return lat;
                    }

                    public void setLat(Double lat)
                    {
                        this.lat = lat;
                    }

                    public Double getLng()
                    {
                        return lng;
                    }

                    public void setLng(Double lng)
                    {
                        this.lng = lng;
                    }
                }
            }

            public static class StreetNumberBean
            {
                /**
                 * id : 595672509379194165901290
                 * title : 北四环西路66号
                 * location : {"lat":39.984089,"lng":116.308037}
                 * _distance : 45.8
                 * _dir_desc : 
                 */

                private String id;
                private String title;
                private LocationBeanXXXXXX location;
                private Double _distance;
                private String _dir_desc;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public String getTitle()
                {
                    return title;
                }

                public void setTitle(String title)
                {
                    this.title = title;
                }

                public LocationBeanXXXXXX getLocation()
                {
                    return location;
                }

                public void setLocation(LocationBeanXXXXXX location)
                {
                    this.location = location;
                }

                public Double get_distance()
                {
                    return _distance;
                }

                public void set_distance(Double _distance)
                {
                    this._distance = _distance;
                }

                public String get_dir_desc()
                {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc)
                {
                    this._dir_desc = _dir_desc;
                }

                public static class LocationBeanXXXXXX
                {
                    /**
                     * lat : 39.984089
                     * lng : 116.308037
                     */

                    private Double lat;
                    private Double lng;

                    public Double getLat()
                    {
                        return lat;
                    }

                    public void setLat(Double lat)
                    {
                        this.lat = lat;
                    }

                    public Double getLng()
                    {
                        return lng;
                    }

                    public void setLng(Double lng)
                    {
                        this.lng = lng;
                    }
                }
            }

            public static class StreetBean
            {
                /**
                 * id : 9217092216709107946
                 * title : 彩和坊路
                 * location : {"lat":39.97921,"lng":116.308411}
                 * _distance : 46.6
                 * _dir_desc : 西
                 */

                private String id;
                private String title;
                private LocationBeanXXXXXXX location;
                private Double _distance;
                private String _dir_desc;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public String getTitle()
                {
                    return title;
                }

                public void setTitle(String title)
                {
                    this.title = title;
                }

                public LocationBeanXXXXXXX getLocation()
                {
                    return location;
                }

                public void setLocation(LocationBeanXXXXXXX location)
                {
                    this.location = location;
                }

                public Double get_distance()
                {
                    return _distance;
                }

                public void set_distance(Double _distance)
                {
                    this._distance = _distance;
                }

                public String get_dir_desc()
                {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc)
                {
                    this._dir_desc = _dir_desc;
                }

                public static class LocationBeanXXXXXXX
                {
                    /**
                     * lat : 39.97921
                     * lng : 116.308411
                     */

                    private Double lat;
                    private Double lng;

                    public Double getLat()
                    {
                        return lat;
                    }

                    public void setLat(Double lat)
                    {
                        this.lat = lat;
                    }

                    public Double getLng()
                    {
                        return lng;
                    }

                    public void setLng(Double lng)
                    {
                        this.lng = lng;
                    }
                }
            }

            public static class LandmarkL2Bean
            {
                /**
                 * id : 3629720141162880123
                 * title : 中国技术交易大厦
                 * location : {"lat":39.984253,"lng":116.307472}
                 * _distance : 0
                 * _dir_desc : 内
                 */

                private String id;
                private String title;
                private LocationBeanXXXXXXXX location;
                private Integer _distance;
                private String _dir_desc;

                public String getId()
                {
                    return id;
                }

                public void setId(String id)
                {
                    this.id = id;
                }

                public String getTitle()
                {
                    return title;
                }

                public void setTitle(String title)
                {
                    this.title = title;
                }

                public LocationBeanXXXXXXXX getLocation()
                {
                    return location;
                }

                public void setLocation(LocationBeanXXXXXXXX location)
                {
                    this.location = location;
                }

                public Integer get_distance()
                {
                    return _distance;
                }

                public void set_distance(Integer _distance)
                {
                    this._distance = _distance;
                }

                public String get_dir_desc()
                {
                    return _dir_desc;
                }

                public void set_dir_desc(String _dir_desc)
                {
                    this._dir_desc = _dir_desc;
                }

                public static class LocationBeanXXXXXXXX
                {
                    /**
                     * lat : 39.984253
                     * lng : 116.307472
                     */

                    private Double lat;
                    private Double lng;

                    public Double getLat()
                    {
                        return lat;
                    }

                    public void setLat(Double lat)
                    {
                        this.lat = lat;
                    }

                    public Double getLng()
                    {
                        return lng;
                    }

                    public void setLng(Double lng)
                    {
                        this.lng = lng;
                    }
                }
            }
        }

        public static class PoisBean
        {
            /**
             * id : 3629720141162880123
             * title : 中国技术交易大厦
             * address : 北京市海淀区北四环西路66号
             * category : 房产小区:商务楼宇
             * location : {"lat":39.984253,"lng":116.307472}
             * ad_info : {"adcode":"110108","province":"北京市","city":"北京市","district":"海淀区"}
             * _distance : 0
             * _dir_desc : 内
             */

            private String id;
            private String title;
            private String address;
            private String category;
            private LocationBeanXXXXXXXXX location;
            private AdInfoBeanX ad_info;
            private Integer _distance;
            private String _dir_desc;

            public String getId()
            {
                return id;
            }

            public void setId(String id)
            {
                this.id = id;
            }

            public String getTitle()
            {
                return title;
            }

            public void setTitle(String title)
            {
                this.title = title;
            }

            public String getAddress()
            {
                return address;
            }

            public void setAddress(String address)
            {
                this.address = address;
            }

            public String getCategory()
            {
                return category;
            }

            public void setCategory(String category)
            {
                this.category = category;
            }

            public LocationBeanXXXXXXXXX getLocation()
            {
                return location;
            }

            public void setLocation(LocationBeanXXXXXXXXX location)
            {
                this.location = location;
            }

            public AdInfoBeanX getAd_info()
            {
                return ad_info;
            }

            public void setAd_info(AdInfoBeanX ad_info)
            {
                this.ad_info = ad_info;
            }

            public Integer get_distance()
            {
                return _distance;
            }

            public void set_distance(Integer _distance)
            {
                this._distance = _distance;
            }

            public String get_dir_desc()
            {
                return _dir_desc;
            }

            public void set_dir_desc(String _dir_desc)
            {
                this._dir_desc = _dir_desc;
            }

            public static class LocationBeanXXXXXXXXX
            {
                /**
                 * lat : 39.984253
                 * lng : 116.307472
                 */

                private Double lat;
                private Double lng;

                public Double getLat()
                {
                    return lat;
                }

                public void setLat(Double lat)
                {
                    this.lat = lat;
                }

                public Double getLng()
                {
                    return lng;
                }

                public void setLng(Double lng)
                {
                    this.lng = lng;
                }
            }

            public static class AdInfoBeanX
            {
                /**
                 * adcode : 110108
                 * province : 北京市
                 * city : 北京市
                 * district : 海淀区
                 */

                private String adcode;
                private String province;
                private String city;
                private String district;

                public String getAdcode()
                {
                    return adcode;
                }

                public void setAdcode(String adcode)
                {
                    this.adcode = adcode;
                }

                public String getProvince()
                {
                    return province;
                }

                public void setProvince(String province)
                {
                    this.province = province;
                }

                public String getCity()
                {
                    return city;
                }

                public void setCity(String city)
                {
                    this.city = city;
                }

                public String getDistrict()
                {
                    return district;
                }

                public void setDistrict(String district)
                {
                    this.district = district;
                }
            }
        }
    }
}
