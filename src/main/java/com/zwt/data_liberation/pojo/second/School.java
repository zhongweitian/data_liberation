package com.zwt.data_liberation.pojo.second;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 11:12
 */
public class School {
    private Long id;

    private String SchoolName;

    private String SchoolDescribe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getSchoolDescribe() {
        return SchoolDescribe;
    }

    public void setSchoolDescribe(String schoolDescribe) {
        SchoolDescribe = schoolDescribe;
    }

    @Override
    public String toString() {
        return "SchoolVo{" +
                "id=" + id +
                ", SchoolName='" + SchoolName + '\'' +
                ", SchoolDescribe='" + SchoolDescribe + '\'' +
                '}';
    }
}
