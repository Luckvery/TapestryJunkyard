function ddate()
{

//Set the two dates
    var Dday = new Date(2011, 11, 16) //Month is 0-11 in JavaScript
    today = new Date()
//Get 1 day in milliseconds
    var one_day = 1000 * 60 * 60 * 24

//Calculate difference btw the two dates, and convert to days
     return (Math.ceil((today.getTime() - Dday.getTime()) / (one_day)) )
}
