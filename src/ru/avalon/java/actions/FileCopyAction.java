package ru.avalon.java.actions;

import java.io.*;
import java.nio.file.*;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {

    private Path source;
    private Path target;

    public FileCopyAction(String source, String target) throws FileNotFoundException {
        this.source = Paths.get(source);
        this.target = Paths.get(target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        synchronized (mutex) {
            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        source = null;
        target = null;
    }
}
