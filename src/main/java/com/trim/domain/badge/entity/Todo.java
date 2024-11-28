package com.trim.domain.badge.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Todo {
    TODO_TYPE_1("comment"), TODO_TYPE_2("join");        //example
    private final String type;
}
