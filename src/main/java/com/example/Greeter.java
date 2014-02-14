package com.example;

import akka.actor.UntypedActor;

/**
 * Created by derya on 13/02/14.
 */
public class Greeter extends UntypedActor {
    public static enum Msg{
        GREET, DONE;
    }

    @Override
    public void onReceive(Object msg){
        if (msg == Msg.GREET){
            System.out.println("Hello World!!");
            getSender().tell(Msg.DONE,getSelf());
        } else unhandled(msg);
    }

}
