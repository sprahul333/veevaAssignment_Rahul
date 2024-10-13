package business;

import framework.Loggers;
import framework.ReusableLibrary;
import framework.SuiteUtil;
import pageActions.BullsPageActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BullsBusiness extends ReusableLibrary {

    BullsPageActions bullsPageActions = new BullsPageActions();

    public void captureFooterLinks() {
        actionsUtil.scrollPageToTheBottom();

        List<String> footerLinks =new ArrayList<String>();

        bullsPageActions.clickOnFooterLink().forEach(footerLink -> {
            String href=footerLink.getAttribute("href");
            Loggers.writeDataToTheFile(SuiteUtil.getCSVFilePath(),href);
            footerLinks.add(href);
        });

        Set<String> listOfDuplicates=footerLinks.stream().filter(e -> Collections.frequency(footerLinks,e)>1)
                .collect(java.util.stream.Collectors.toSet());

    }
}
