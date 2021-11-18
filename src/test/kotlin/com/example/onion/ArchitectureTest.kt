package com.example.onion

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.library.Architectures.onionArchitecture
import com.tngtech.archunit.library.dependencies.SliceAssignment
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition
import org.junit.jupiter.api.Test

class ArchitectureTest {

    private val onionPackage = "com.example.onion"
    private val fooPackage = "com.example.foo"
    private val importedClasses = ClassFileImporter()
        .withImportOption(ImportOption.DoNotIncludeTests())
        .importPackages(onionPackage, fooPackage)

    @Test
    fun portAndAdapters() {
        val rule = onionArchitecture()
            .domainModels("$onionPackage.domain.model..", "$fooPackage.domain.model..")
            .domainServices("$onionPackage.domain.service..", "$fooPackage.domain.service..")
            .applicationServices("$onionPackage.application..", "$fooPackage.application..")
            .adapter("persistence", "$onionPackage.adapter.persistence..", "$fooPackage.adapter.persistence..")
            .adapter("web", "$onionPackage.adapter.web..", "$fooPackage.adapter.web..")
            .adapter("external", "$onionPackage.adapter.external..")
            .adapter("facade", "$onionPackage.adapter..", "$fooPackage.adapter..")
            .withOptionalLayers(true)

        rule.check(importedClasses)
    }

    @Test
    fun modularity() {
        val domain = SlicesRuleDefinition.slices()
                .matching("..example.(*).domain..")
                .should()
                .notDependOnEachOther()

        val api = SlicesRuleDefinition.slices()
            .matching("..example.(*).application..")
            .should()
            .notDependOnEachOther()

        domain.check(importedClasses)
        api.check(importedClasses)
    }
}