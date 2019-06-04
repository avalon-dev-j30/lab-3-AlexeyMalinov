package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreateLinkAction implements Action {

    Path source;
    Path link;

    public FileCreateLinkAction(String source, String link) {
        this.source = Paths.get(source);
        this.link = Paths.get(link);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        synchronized (mutex) {
            try {
                Files.createLink(link, source);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        source = null;
        link = null;
    }
}
