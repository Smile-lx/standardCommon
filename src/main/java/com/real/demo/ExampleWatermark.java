package com.real.demo;

import com.aspose.pdf.*;
import com.aspose.pdf.facades.EncodingType;
import com.aspose.pdf.facades.FontStyle;
import com.aspose.pdf.facades.FormattedText;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName ExampleWatermark
 * @Description: TODO
 * @Author Smile
 * @Date 2021/6/9
 * @Version V1.0
 **/
public class ExampleWatermark {
    // The path to the documents directory.
    private static String _dataDir = "src/main/resources/";

    public static void main(String[] args) {
      getLicense();
        // Open document
        Document doc = new Document(_dataDir + "请假单.pdf");
        FormattedText formattedText = new FormattedText("Watermark", java.awt.Color.BLUE, FontStyle.Courier, EncodingType.Identity_h, true, 72.0F);
        WatermarkArtifact artifact = new WatermarkArtifact();
        artifact.setText(formattedText);
        artifact.setArtifactHorizontalAlignment (HorizontalAlignment.Center);
        artifact.setArtifactVerticalAlignment (VerticalAlignment.Center);
        artifact.setRotation (45);
        artifact.setOpacity (0.5);
        artifact.setBackground (true);
        doc.getPages().get_Item(1).getArtifacts().add(artifact);
        doc.save(_dataDir + "watermark.pdf");
    }

    public static boolean getLicense() {
        boolean flag = false;
        try {
//            String licenseStr =
//                    "<License>\n" +
//                            "    <Data>\n" +
//                            "        <Products>\n" +
//                            "            <Product>Aspose.Total for Java</Product>\n" +
//                            "        </Products>\n" +
//                            "        <EditionType>Enterprise</EditionType>\n" +
//                            "        <SubscriptionExpiry>20991231</SubscriptionExpiry>\n" +
//                            "        <LicenseExpiry>20991231</LicenseExpiry>\n" +
//                            "        <SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber>\n" +
//                            "    </Data>\n" +
//                            "    <Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature>\n" +
//                            "</License";
//            InputStream license = new ByteArrayInputStream(licenseStr.getBytes(StandardCharsets.UTF_8));
            File file = new File("src/main/resources/License.xml");
            InputStream is = new FileInputStream(file);
            License asposeLic = new License();
            asposeLic.setLicense(is);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;

    }
}
