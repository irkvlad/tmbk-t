package com.company.tmbkt.web.trawlapplication;

import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.data.ValueListener;
import com.haulmont.thesis.web.actions.PrintReportAction;
import com.haulmont.thesis.web.ui.basicdoc.editor.AbstractDocEditor;
import com.haulmont.workflow.core.app.WfUtils;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Label;
import org.apache.commons.lang.StringUtils;
import com.haulmont.cuba.core.entity.Entity;
import java.util.Map;
import com.company.tmbkt.entity.TrawlApplication;
import javax.inject.Inject;

public class TrawlApplicationEdit extends AbstractDocEditor<TrawlApplication> {
    @Inject
    private CheckBox checkBoxOur;

    @Inject
    private CheckBox cardCheckBoxThird;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
   
        checkBoxOur.addListener(new ValueListener<Object>() {
            @Override
            public void valueChanged(Object source, String property, Object prevValue, Object value) {
                if (Boolean.TRUE.equals(value)) {
                    cardCheckBoxThird.setValue(null);
                    cardCheckBoxThird.setEditable(true);
                    checkBoxOur.setEditable(false);
                    //showNotification("Наша техника", NotificationType.HUMANIZED);
                }
            }
        });

        cardCheckBoxThird.addListener(new ValueListener<Object>() {
            @Override
            public void valueChanged(Object source, String property, Object prevValue, Object value) {
                if (Boolean.TRUE.equals(value)) {
                    checkBoxOur.setValue(null);
                    checkBoxOur.setEditable(true);
                    cardCheckBoxThird.setEditable(false);
                    //showNotification("Стооняя техника", NotificationType.HUMANIZED);
                }
            }
        });
}

    @Override
    protected String getHiddenTabsConfig() {
        return "correspondenceHistoryTab,docLogTab,cardLinksTab,securityTab,docTransferLogTab,cardProjectsTab,versionsTab,openHistoryTab";
    }

    @Override
    public void setItem(Entity item) {
        super.setItem(item);
        printButton.addAction(new PrintReportAction("printExecutionList", this, "printDocExecutionListReportName"));
    }

    @Override
    protected Component createState() {
        if (WfUtils.isCardInState(getItem(), "New") || StringUtils.isEmpty(getItem().getState())) {
            Label label = componentsFactory.createComponent(Label.NAME);
            label.setValue(StringUtils.isEmpty(getItem().getState()) ? "" : getItem().getLocState());
            return label;
        } else {
            return super.createState();
        }
    }

    @Override
    protected void fillHiddenTabs() {
        hiddenTabs.put("office", getMessage("office"));
        hiddenTabs.put("attachmentsTab", getMessage("attachmentsTab"));
        hiddenTabs.put("docTreeTab", getMessage("docTreeTab"));
        hiddenTabs.put("cardCommentTab", getMessage("cardCommentTab"));
        super.fillHiddenTabs();
    }
}