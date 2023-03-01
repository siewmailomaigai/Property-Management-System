/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountExecutive;

import java.io.IOException;

/**
 *
 * @author 60192
 */
public class Driver {

    public static void main(String[] args) throws IOException {
        //IssueInvoice invoice = new IssueInvoice();
        //invoice.runInvoice();

        OutstandingFee fee = new OutstandingFee();
        fee.addOutstanding();
    }
}
