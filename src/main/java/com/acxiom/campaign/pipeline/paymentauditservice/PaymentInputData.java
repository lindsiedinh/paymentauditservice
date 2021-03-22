package com.acxiom.campaign.pipeline.paymentauditservice;

import java.io.Serializable;

/**
 * Created by mlalapet on 9/24/18.
 */
public class PaymentInputData implements Serializable {
    private String customerId;
    private double ct_amt_lst_pay_d;
    private String ct_date_lst_pay;
    private double ct_late_fee;
    private double ct_lc_late_fees_d;
    private int ct_pay_due_date_counter;
    private String ct_payment_date;
    private double ct_tot_balance_amt;
    private double ct_tot_ca_balance_d;
    private double ct_tot_delq_bill_amt_d;
    private double ct_tot_pur_balance_d;
    private double ct_totl_pay_amt_d;
    private double ct_ytd_late_fee;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getCt_amt_lst_pay_d() {
        return ct_amt_lst_pay_d;
    }

    public void setCt_amt_lst_pay_d(double ct_amt_lst_pay_d) {
        this.ct_amt_lst_pay_d = ct_amt_lst_pay_d;
    }

    public String getCt_date_lst_pay() {
        return ct_date_lst_pay;
    }

    public void setCt_date_lst_pay(String ct_date_lst_pay) {
        this.ct_date_lst_pay = ct_date_lst_pay;
    }

    public double getCt_late_fee() {
        return ct_late_fee;
    }

    public void setCt_late_fee(double ct_late_fee) {
        this.ct_late_fee = ct_late_fee;
    }

    public double getCt_lc_late_fees_d() {
        return ct_lc_late_fees_d;
    }

    public void setCt_lc_late_fees_d(double ct_lc_late_fees_d) {
        this.ct_lc_late_fees_d = ct_lc_late_fees_d;
    }

    public int getCt_pay_due_date_counter() {
        return ct_pay_due_date_counter;
    }

    public void setCt_pay_due_date_counter(int ct_pay_due_date_counter) {
        this.ct_pay_due_date_counter = ct_pay_due_date_counter;
    }

    public String getCt_payment_date() {
        return ct_payment_date;
    }

    public void setCt_payment_date(String ct_payment_date) {
        this.ct_payment_date = ct_payment_date;
    }

    public double getCt_tot_balance_amt() {
        return ct_tot_balance_amt;
    }

    public void setCt_tot_balance_amt(double ct_tot_balance_amt) {
        this.ct_tot_balance_amt = ct_tot_balance_amt;
    }

    public double getCt_tot_ca_balance_d() {
        return ct_tot_ca_balance_d;
    }

    public void setCt_tot_ca_balance_d(double ct_tot_ca_balance_d) {
        this.ct_tot_ca_balance_d = ct_tot_ca_balance_d;
    }

    public double getCt_tot_delq_bill_amt_d() {
        return ct_tot_delq_bill_amt_d;
    }

    public void setCt_tot_delq_bill_amt_d(double ct_tot_delq_bill_amt_d) {
        this.ct_tot_delq_bill_amt_d = ct_tot_delq_bill_amt_d;
    }

    public double getCt_tot_pur_balance_d() {
        return ct_tot_pur_balance_d;
    }

    public void setCt_tot_pur_balance_d(double ct_tot_pur_balance_d) {
        this.ct_tot_pur_balance_d = ct_tot_pur_balance_d;
    }

    public double getCt_totl_pay_amt_d() {
        return ct_totl_pay_amt_d;
    }

    public void setCt_totl_pay_amt_d(double ct_totl_pay_amt_d) {
        this.ct_totl_pay_amt_d = ct_totl_pay_amt_d;
    }

    public double getCt_ytd_late_fee() {
        return ct_ytd_late_fee;
    }

    public void setCt_ytd_late_fee(double ct_ytd_late_fee) {
        this.ct_ytd_late_fee = ct_ytd_late_fee;
    }
}
