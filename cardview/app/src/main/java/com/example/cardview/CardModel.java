package com.example.cardview;

public class CardModel {
    private String emp_name;

    public String getEmp_description() {
        return emp_description;
    }

    private String emp_description;
    private int emp_image;

    public CardModel(String emp_name, String emp_description, int emp_image) {
            this.emp_name = emp_name;
            this.emp_description = emp_description;
            this.emp_image = emp_image;
        }

        public String getEmp_name() {
            return emp_name;
        }

        public void setEmp_name(String emp_name) {
            this.emp_name = emp_name;
        }

    public void setEmp_image(String emp_description) {
        this.emp_description = emp_description;
    }

        public void setEmp_description(String emp_description) {
            this.emp_description = emp_description;
        }

        public int getEmp_image() {
            return emp_image;
        }

        public void setEmp_image(int emp_image) {
            this.emp_image = emp_image;
        }
    }
