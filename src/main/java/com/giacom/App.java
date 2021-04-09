package com.giacom;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class App {
    public static void main(String[] args) {
        try {
            PDDocument pDDocument = PDDocument.load(new File("C:\\Users\\hungtt\\Desktop\\mau_don_1.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("p_full_name");
            field.setValue("This is a first field printed by Java");
            field = pDAcroForm.getField("p_gttt");
            field.setValue("This is a second field printed by Java");
            PDField checkBox = pDAcroForm.getField("p_check_id");
            checkBox.setValue("Yes");
            PDField comboBox = pDAcroForm.getField("p_comb_name");
            comboBox.setValue("TRAN TIEN HUNG");
            pDDocument.save("C:\\\\Users\\\\hungtt\\\\Desktop\\\\mau_don_1_result.pdf");
            pDDocument.close();
            System.out.println("DOne!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
