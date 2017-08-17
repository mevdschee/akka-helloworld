package com.example;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.ActorRef;
import kamon.Kamon;

/**
 * Created by derya on 13/02/14.
 */
public class HelloWorld extends UntypedActor {
    @Override
    public void preStart(){
Kamon.start();
        //create the greeter actor
        final ActorRef greeter = getContext().actorOf(Props.create(Greeter.class),"greeter" );
        // tell it to perform greeting
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    @Override
    public void onReceive(Object msg){
        if(msg== Greeter.Msg.DONE){
            //getContext().stop(getSelf());
        } else unhandled(msg);
    }
}
