package fi.muni.pv207.ticket;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class BusinessCase implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   @org.kie.api.definition.type.Label("Tile")
   private java.lang.String title;
   @org.kie.api.definition.type.Label("Description")
   private java.lang.String description;
   @org.kie.api.definition.type.Label("Priority")
   private java.lang.Integer priority;
   @org.kie.api.definition.type.Label("Email")
   private java.lang.String email;
   @org.kie.api.definition.type.Label("Id")
   private java.lang.Integer id;

   public BusinessCase()
   {
   }

   public java.lang.String getTitle()
   {
      return this.title;
   }

   public void setTitle(java.lang.String title)
   {
      this.title = title;
   }

   public java.lang.String getDescription()
   {
      return this.description;
   }

   public void setDescription(java.lang.String description)
   {
      this.description = description;
   }

   public java.lang.Integer getPriority()
   {
      return this.priority;
   }

   public void setPriority(java.lang.Integer priority)
   {
      this.priority = priority;
   }

   public java.lang.String getEmail()
   {
      return this.email;
   }

   public void setEmail(java.lang.String email)
   {
      this.email = email;
   }

   public java.lang.Integer getId()
   {
      return this.id;
   }

   public void setId(java.lang.Integer id)
   {
      this.id = id;
   }

   public BusinessCase(java.lang.String title, java.lang.String description,
         java.lang.Integer priority, java.lang.String email, java.lang.Integer id)
   {
      this.title = title;
      this.description = description;
      this.priority = priority;
      this.email = email;
      this.id = id;
   }

   @Override
   public String toString() {
      return "BusinessCase{" +
              "title='" + title + '\'' +
              ", description='" + description + '\'' +
              ", priority=" + priority +
              ", email='" + email + '\'' +
              ", id=" + id +
              '}';
   }
}