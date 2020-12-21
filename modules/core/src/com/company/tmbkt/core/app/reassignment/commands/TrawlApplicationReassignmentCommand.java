/*
 * Copyright (c) 2020 com.company.tmbkt.core.app.reassignment.commands
 */
package com.company.tmbkt.core.app.reassignment.commands;


import com.haulmont.thesis.core.app.reassignment.commands.AbstractDocReassignmentCommand;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import com.company.tmbkt.entity.TrawlApplication;

/**
 * @author Владимир Лощилов
 */
@ManagedBean(TrawlApplicationReassignmentCommand.NAME)
public class TrawlApplicationReassignmentCommand extends AbstractDocReassignmentCommand<TrawlApplication> {
    protected static final String NAME = "trawlapplication_reassignment_command";

    @PostConstruct
    protected void postInit() {
        type = "TrawlApplication";
        docQuery = String.format(DOC_QUERY_TEMPLATE, "tmbkt$TrawlApplication");
    }

    @Override
    public String getName() {
        return NAME;
    }
}