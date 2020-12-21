package com.company.tmbkt.web.trawlapplication;

import java.util.Map;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.thesis.web.ui.basicdoc.browse.AbstractDocBrowser;
import com.company.tmbkt.entity.TrawlApplication;

public class TrawlApplicationBrowse extends AbstractDocBrowser<TrawlApplication> {

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        entityName = "tmbkt$TrawlApplication";
    }
}