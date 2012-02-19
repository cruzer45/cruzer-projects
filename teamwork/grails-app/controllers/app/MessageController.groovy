package app

class MessageController {
        
    def index = 
    {
        redirect (action:"create")
    }
    
    def create = {
        return [ message: new Message() ]
    }
    
    def save = {
        def message = new Message( params )
        if( !message.hasErrors() && message.save() ) 
        {
            flash.toUser = "Message [${message.title}] has been added."
            redirect( action: 'create' )
        } 
        else 
        {
            render( view: 'create', model:[message: message] )
        }
    }
}