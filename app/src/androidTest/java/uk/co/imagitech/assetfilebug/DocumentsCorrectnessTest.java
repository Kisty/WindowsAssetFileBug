package uk.co.imagitech.assetfilebug;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by TimKist on 21/07/2015.
 */
@RunWith(AndroidJUnit4.class)
@MediumTest
public class DocumentsCorrectnessTest {

    @Test
    public void test_allDocumentsPresent() throws IOException {
        final Context targetContext = InstrumentationRegistry.getTargetContext();
        List<String> missingList = new ArrayList<>();
        String docUri = "file:///android_asset/Documents/Bookingatest/Bookingatest.htm";
        //Check for each vehicle type
        //If the res of the uri to the documents for different test types are the same, then
        InputStream in = null;
        try {
            //Remove asset part from it
            docUri = docUri.replace("file:///android_asset/", "");
            in = targetContext.getAssets().open(docUri);
        } catch (IOException e) {
            missingList.add(docUri);
        } finally {
            if (in != null) {
                in.close();
            }
        }
        String[] assetFiles = targetContext.getAssets().list("Documents/Bookingatest");
        Assert.assertTrue("Missing file: " + missingList.toString() + " Found instead: " + Arrays.toString(assetFiles), missingList.isEmpty());
    }
}
