package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {

    private Path source;
    private Path target;

    public FileMoveAction(String source, String target) {
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
                Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
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
