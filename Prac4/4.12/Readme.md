
4.12 Time Updater in Servlet
----------------------------
In this program we are going to make one program on servlet which will keep on updating the time in every second and the result will be displayed to you.
To make this servlet firstly we need to make a class named TimeUpdater.  The name of the class should be such that it becomes easy to understand what the program is going to do. Call the method getWriter() method of the response object which will return a PrintWriter object. Use the method getHeader() of the response object to add a new header. We can also use setHeader() in place of getHeader(). The setHeader() method overrides the previous set header. Now by using the PrintWriter object display the result on the browser.


![4 4](https://cloud.githubusercontent.com/assets/16952223/13035005/9844b886-d36a-11e5-8562-c5d81658f766.JPG)
