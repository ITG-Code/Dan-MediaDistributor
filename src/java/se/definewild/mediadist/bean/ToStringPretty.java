package se.definewild.mediadist.bean;

import java.lang.reflect.Field;

public abstract class ToStringPretty<T> {
  private T instance;
  private Class<T> clazz;

  public ToStringPretty() {
    this.instance = null;
    this.clazz = null;
  }
  
  public void Set(T instance) {
    this.instance = instance;
    this.clazz = (Class<T>) instance.getClass();
  }

  @Override
  public String toString() {
    if (instance == null)
      return "NULL";
    
    StringBuilder sb = new StringBuilder();
    sb.append(clazz.getName()).append("{");
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields)
      try {
        if (field.getName().contains("Facade"))
          continue;
        
        boolean access = field.isAccessible();
        field.setAccessible(true);
        sb.append(field.getName()).append("=").append(field.get(instance));
        field.setAccessible(access);
        sb.append(", ");
      } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
      }
    sb.append("}");
    return sb.toString();
  }
  
}
