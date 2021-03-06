/*
 * generated by Xtext
 */
package de.tubs.bibtextohtml.bibtex.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class BibTeXUiModule extends de.tubs.bibtextohtml.bibtex.ui.AbstractBibTeXUiModule {
	public BibTeXUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	// inject own highlighting configuration
	public Class<? extends IHighlightingConfiguration> bindSemanticConfig() {
		return BibtexHighlightingConfiguration.class;
	}

	// inject own semantic highlighting
	public Class<? extends ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		return BibtexSemanticHighlightingCalculator.class;
	}
}
