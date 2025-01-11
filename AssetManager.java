
import java.io.IOException ;
import java.nio.file.Files ;
import java.nio.file.Path ;
import java.nio.file.Paths ;
import java.util.HashMap ;
import java.util.stream.Stream ;

/**
 * Loads and provides access to assets.
 */
public class AssetManager
    {

    private static final String ASCII_ART_PATH = "assets/ascii-art" ;
    private static final String DIALOGUE_PATH = "assets/dialogue" ;

    private final HashMap<String, String> asciiArt = new HashMap<>() ;
    private final HashMap<String, String> dialogue = new HashMap<>() ;

    /**
     * Gets ASCII art with the specified key.
     * 
     * @param key
     *     Unique identifier.
     * 
     * @return asciiArt in the form of a string
     */
    public String getAsciiArt( String key )
        {
        return this.asciiArt.getOrDefault( key, "" ) ;

        }


    /**
     * Gets a line of dialogue with the specified key.
     * 
     * @param key
     *     Unique identifier.
     * 
     * @return a string
     */
    public String getDialogue( String key )
        {
        return this.dialogue.getOrDefault( key, "" ) ;

        }


    /**
     * Loads all assets from the specified directory.
     * 
     * @param path
     *     Path to directory containing assets folder.
     * 
     * @throws IOException
     *     yea it does
     */
    public void load( Path path ) throws IOException
        {

        loadDialogue( path ) ;
        loadAsciiArt( path ) ;

        }


    private void loadAsciiArt( Path path ) throws IOException
        {
        try ( Stream<Path> paths = Files.walk( path.resolve( Paths.get( ASCII_ART_PATH ) ) ) )
            {
            paths.forEach( ( Path p ) ->
                {

                if ( Files.isDirectory( p ) )
                    {
                    return ;
                    }

                try
                    {
                    String key = removeFileExtension( p.getFileName().toString() ) ;
                    String value = Files.readString( p ) ;
                    this.asciiArt.put( key, value ) ;

                    }
                catch ( IOException ex )
                    {}

                } ) ;

            }
        catch ( IOException e )
            {
            e.printStackTrace() ; // Handle any issues with Files.walk
            throw e ; // Rethrow to inform the caller

            }

        }


    private void loadDialogue( Path path ) throws IOException
        {
        try ( Stream<Path> paths = Files.walk( path.resolve( Paths.get( DIALOGUE_PATH ) ) ) )
            {
            paths.forEach( p ->
                {
                if ( Files.isDirectory( p ) )
                    {
                    return ;

                    }

                try
                    {
                    for ( String line : Files.readAllLines( p ) )
                        {
                        int index = line.indexOf( '|' ) ;
                        if ( index == -1 )
                            {
                            continue ; // Skip lines without the delimiter

                            }

                        String key = line.substring( 0, index ).trim() ;
                        String value = line.substring( index + 1 ).trim() ;
                        this.dialogue.put( key, value ) ;

                        }

                    }
                catch ( IOException ex )
                    {
                    ex.printStackTrace() ; // Log the error for debugging

                    }

                } ) ;

            }
        catch ( IOException e )
            {
            e.printStackTrace() ; // Handle any issues with Files.walk
            throw e ; // Rethrow to inform the caller

            }

        }


    private static String removeFileExtension( String filename )
        {
        return filename.replaceFirst( "[.][^.]+$", "" ) ;

        }

    }
