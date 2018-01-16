import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * Imprime por terminal de texto toda la lista de archivos.
     */
    public void listAllFiles() {
        int position = 1;
        for(String file : files) {
            System.out.println(position + "- " + file);
            position++;
        }
    }
    
    /**
     * Imprime por terminal de texto los archivos que se corresponden con el searchString de busqueda.
     * El metodo es sensible a mayusculas y minusculas.
     * @param searchString La cadena a buscar.
     */
    public void listMatching(String searchString) {
        boolean coincidencias = false;
        for(String file : files) {
            if(file.contains(searchString)) {
               System.out.println(file); 
               coincidencias = true;
            }
        }
        if (!coincidencias) {
            System.out.println("No se han hallado coincidencias");
        }
    }
    
    /**
     * Reproduce muestras de todas las canciones que coincidan con la cadena indicada.
     * El metodo es sensible a mayusculas y minusculas.
     * @param searchString La cadena a buscar.
     */
    public void playSomethingOf(String searchString) {
        for(String file : files) {
            if(file.contains(searchString)) {
               player.playSample(file); 
            }
        }
    }
    
    /**
     * Localiza el indice del primer archivo que se corresponde con
     * la cadena de busqueda indicada.
     * @param searchString La cadena a buscar.
     * @return El indice de la primera aparicion. 
     * (-1 si no hay correspondencias)
     */
    public int findFirst(String searchString) {
        int index = 0, filesSize = files.size();
        // Mientras sea true, seguimos buscando.
        boolean searching = true;
        while(searching && index < filesSize) {
            String filename = files.get(index);
            if(filename.contains(searchString)) {
                searching = false;
            }
            else {
                index++;
            }
        }
        if(searching) {
            index = -1;
        }
        return index;
    }
}
