package com.example.junkyard.components;


import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Layout component for pages of application junkyard.
 */


public class Layout
{
    /**
     * The page title, for the <title> element and the <h1> element.
     */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property
    private String pageName;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String sidebarTitle;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private Block sidebar;

    @Inject
    private ComponentResources resources;

    @Property
    @Inject
    @Symbol(SymbolConstants.APPLICATION_VERSION)
    private String appVersion;

    private List<String> quote;

    @Property
    private String randomQuote;

    void SetupRender() {


        Random picker = new Random(); //Superficial random number generator
        if (quote == null) {
            List<String> quote = Arrays.asList(
                    "Life is like Stepping onto a boat which is about to sail out to sea and sink -- Suzuki Roshi, Zen master",
                    "May you live in interesting times, and attract the attention of important people.-- Full version of famous chinese curse",
                    "One of the symptoms of an approaching nervous breakdown is the belief that one's work is terribly important.-- Bertrand Russell",
                    "Some would sooner die than think.  In fact, they often do.-- Bertrand Russell",
                    "It is the mark of an educated mind to be able to entertain a thought without accepting it.-- Aristotle",
                    "If you don't like the emotional experience you're having, change your mind-- Peter Russel peterrussell.com",
                    "Whenever you point your finger at someone, you have *3* pointed at yourself.-- Hindu proverb",
                    "The tragedy of this life is not failure, but low aim.-- Benjamin Mays",
                    "Nothing recedes like success.  -- Walter Winchell",
                    "Think universally, Act Selfishly   --Unknown",
                    "Do not argue with an idiot. He will drag you down to his level and beat you with experience.",
                    "I want to die peacefully in my sleep, like my grandfather.. Not screaming and yelling like the passengers in his car.",
                    "I asked God for a bike, but I know God doesn't work that way. So I stole a bike and asked for forgiveness.",
                    "We live in a society where pizza gets to your house before the police.",
                    "Light travels faster than sound. This is why some people appear bright until you hear them speak.",
                    "If I agreed with you we'd both be wrong.",
                    "We never really grow up, we only learn how to act in public.",
                    "War does not determine who is right - only who is left.",
                    "Knowledge is knowing a tomato is a fruit; Wisdom is not putting it in a fruit salad.",
                    "Children: You spend the first 2 years of their life teaching them to walk and talk. Then you spend the next 16 years telling them to sit down and shut-up.",
                    "Politicians and diapers have one thing in common. They should both be changed regularly, and for the same reason.",
                    "The early bird might get the worm, but the second mouse gets the cheese.",
                    "Evening news is where they begin with 'Good evening', and then proceed to tell you why it isn't.",
                    "Do one thing everyday that scares you.- Eleanor Roosevelt",
                    "We delight in the beauty of the butterfly, but rarely admit the changes it has gone through to achieve that beauty - Maya Angelou",
                    "Do you want to know who you are? Don't ask. Act! Action will delineate and define you. - Thomas Jefferson",
                    "Pain is temporary. Quitting lasts forever. - Lance Armstrong, Every Second Counts",
                    "If you treat an individual as he is, he will remain how he is. But if you treat him as if he were what he ought to be and could be, he will become what he ought to be and could be. - Johann Wolfgang von Goethe",
                    "When all is said and done, more is said than done. - Lou Holtz",
                    "Don't loaf and invite inspiration; light out after it with a club. - Jack London",
                    "You're never as good as everyone tells you when you win, and you're never as bad as they say when you lose. - Lou Holtz",
                    "Never go to bed mad. Stay up and fight. - Phyllis Diller",
                    "I did not attend his funeral, but I sent a nice letter saying I approved of it. - Mark Twain",
                    "If a book about failures doesn't sell, is it a success? - Jerry Seinfeld",
                    "Don't be so humble - you are not that great. - Golda Meir",
                    "A word to the wise ain't necessary, it's the stupid ones who need advice.- Bill Cosby"

            );

            randomQuote = quote.get(picker.nextInt(quote.size()));
        }
    }

    @Import(stylesheet = {
            "context:style/stylesheets/bootstrap.css",

                                       //Temporary css formating
    },

            library = {


                    "context:js/junkyard.js"
            })
    public void afterRender(){return;}
    public String getClassForPageName()
    {
        return resources.getPageName().equalsIgnoreCase(pageName)
                ? "current_page_item"
                : null;
    }

    public String[] getPageNames()
    {
        return new String[]{"Index", "About", "Contact"};
    }
}
