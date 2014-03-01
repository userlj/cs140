package assignment04;

import java.util.logging.Level;

public class Book2
{
   private String title;
   private int pageCount;
   private int bookmark;
   private boolean required;

   public Book2(String title, int pageCount)
   {
      this.title = title;
      this.pageCount = pageCount;
      this.required = true;
      this.bookmark = 0;
   }

   public Book2(String title, int pageCount, boolean required, int bookmark)
   {
      this.title = title;
      this.pageCount = pageCount;
      this.required = required;
      this.bookmark = bookmark;
      
      Book2GUIUpdater.logObj.setLevel(Level.OFF);
      Book2GUIUpdater.logObj.info("Created: " + this + "\n");
      Book2GUIUpdater.logObj.setLevel(Level.ALL);
   }

   public boolean hasBeenRead()
   {
      return bookmark == pageCount;
   }

   public boolean isRequired()
   {
      return required;
   }

   public String getTitle()
   {
      return title;
   }

   public int getPageCount()
   {
      return pageCount;
   }

   public int getBookmark()
   {
      return bookmark;
   }

   public double computeCompleted()
   {
     return bookmark / pageCount;
   }

   public void setBookmark(int newPageNumber)
   {
      bookmark = newPageNumber;
   }

   public String toString()
   {
      return title + ", " + pageCount + 
         ", " + (isRequired() ? "" : "not ") + // Conditional Operator
         "required" +
         ", currently up to page " + bookmark +
         ", " + computeCompleted() * 100 + "% completed";
   }
   
   public String outputLine() {
	      return title + "\t" + pageCount + "\t" + required + "\t" + bookmark;	   
   }
}
