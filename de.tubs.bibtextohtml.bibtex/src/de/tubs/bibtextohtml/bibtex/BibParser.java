package de.tubs.bibtextohtml.bibtex;

//import org.eclipse.emf.mwe.internal.core.ast.util.Injector;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class BibParser {

    @SuppressWarnings("unused")
	@Inject
    private IParser parser;

    public BibParser() {
        setupParser();
    }

    @Inject
    private XtextResourceSet resourceSet;
 
    private void setupParser() {
        new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
        Injector injector = Guice.createInjector(new BibTeXRuntimeModule());
        injector.injectMembers(this);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
    }
 
    /**
     * Parses an input stream and returns the resulting object tree root element.
     * @param in Input Stream
     * @return Root model object
     * @throws IOException When and I/O related parser error occurs
     */
    public EObject parse(InputStream in) throws IOException
    {
        Resource resource = resourceSet.createResource(URI.createURI("dummy:/inmemory.bib"));
        resource.load(in, resourceSet.getLoadOptions());
        return resource.getContents().get(0);
    }
 
    /**
     * Parses a resource specified by an URI and returns the resulting object tree root element.
     * @param uri URI of resource to be parsed
     * @return Root model object
     */
    public EObject parse(URI uri) {
        Resource resource = resourceSet.getResource(uri, true);
        return resource.getContents().get(0);
    }
}