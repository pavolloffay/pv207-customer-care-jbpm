package fi.muni.pv207.ticket;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Employee implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   @org.kie.api.definition.type.Label("Type")
   private java.lang.String type;

   @org.kie.api.definition.type.Label(value = "Id")
   private java.lang.Integer id;

   public Employee()
   {
   }

   public java.lang.String getType()
   {
      return this.type;
   }

   public void setType(java.lang.String type)
   {
      this.type = type;
   }

   public java.lang.Integer getId()
   {
      return this.id;
   }

   public void setId(java.lang.Integer id)
   {
      this.id = id;
   }

   public Employee(java.lang.String type,
         fi.muni.pv207.ticket.BusinessCase businessCase, java.lang.Integer id)
   {
      this.type = type;
      this.id = id;
   }

}
