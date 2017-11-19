/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailClient
{
    // The server used for sending and receiving.
    private MailServer server;
    // The user running this client.
    private String user;
    //mensajes enviados.
    private int entregados;
    //mensajes recibidos.
    private int recibidos;
    //mensaje
    private String mensaje;
    //el numero de caracteres 
    private int caracteres;
    //contador
    private int enviados;
    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
        entregados= 0;
        recibidos = 0;
        mensaje = mensaje;
        caracteres = 0;
        this.enviados = 0;
    }
    
    /**
     * 
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }

    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No new mail.");
        }
        else {
            item.print();
        }
    }

    /**
     * Funcionalidad 05 Aitor Diez
     */
    public void datosmensajes()
    {
        System.out.println("entregados: " + enviados);
        System.out.println("recibidos: " + server.howManyMailItems(user));
        MailItem emailmaslargo = getNextMailItem();
        boolean quedanEmails = true;
        while(quedanEmails){
            MailItem emailservidor = getNextMailItem();
                if (emailservidor == null){
                    quedanEmails = false;
                }
                else{
                    if(emailmaslargo.getMessage().length()>=emailservidor.getMessage().length()){
                emailmaslargo=emailservidor;
            }
   
        }
    
    }
    
        System.out.println("Caracteres mas largo: " + emailmaslargo.getMessage().length());
        System.out.println("direccion" + emailmaslargo.getFrom());
  }
    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to,String subject, String message)
    {
        MailItem item = new MailItem(user, to, subject, message);
        server.post(item);
        enviados += 1;
    }
}