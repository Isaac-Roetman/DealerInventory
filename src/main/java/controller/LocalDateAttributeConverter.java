/**
 * @author Isaac Roetman - ijroetman
 * CIS175 - Spring 2023
 * Mar 1, 2023
 */
package controller;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply =true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate,Date> {
	
	
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return (attribute == null ? null: Date.valueOf(attribute));
	}
	
	
	public LocalDate convertToEntityAttribute(Date dbData) {
		return (dbData == null ? null: dbData.toLocalDate());
	}

}
