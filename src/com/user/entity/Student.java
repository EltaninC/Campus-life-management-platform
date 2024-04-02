package com.user.entity;

public class Student {

        private int s_id;
        private String sort;
        private String s_name;
        private String class_;
        private String college;
        private String gender;

        public Student(int s_id, String sort, String s_name, String class_, String college, String gender) {
            this.s_id = s_id;
            this.sort = sort;
            this.s_name = s_name;
            this.class_ = class_;
            this.college = college;
            this.gender = gender;
        }

    public Student() {

    }

    public int getS_id() {
            return s_id;
        }

        public void setS_id(int s_id) {
            this.s_id = s_id;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getS_name() {
            return s_name;
        }

        public void setS_name(String s_name) {
            this.s_name = s_name;
        }

        public String getClass_() {
            return class_;
        }

        public void setClass_(String class_) {
            this.class_ = class_;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", sort='" + sort + '\'' +
                ", s_name='" + s_name + '\'' +
                ", class_='" + class_ + '\'' +
                ", college='" + college + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}


