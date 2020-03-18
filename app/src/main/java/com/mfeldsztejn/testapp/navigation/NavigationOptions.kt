package com.mfeldsztejn.testapp.navigation

enum class NavigationOptions(val nextSteps: List<String>) {
    OPTION_1_2_3(
        listOf(
            "action_loadingFragment_to_step1_navigation_graph",
            "start_step_2",
            "start_step_3",
            "end_flow"
        )
    ),
    OPTION_3_2_1(
        listOf(
            "action_loadingFragment_to_step3_navigation_graph",
            "start_step_2",
            "start_step_1",
            "end_flow"
        )
    ),
    OPTION_2_3_1(
        listOf(
            "action_loadingFragment_to_step2_navigation_graph",
            "start_step_3",
            "start_step_1",
            "end_flow"
        )
    )
}