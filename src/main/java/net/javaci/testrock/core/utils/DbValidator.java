
package net.javaci.testrock.core.utils;

import net.javaci.testrock.core.dao.Dao;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.ValidationError;
import org.apache.wicket.validation.validator.StringValidator;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

abstract public class DbValidator extends StringValidator {
	private static final long serialVersionUID = 1L;

	/**
	 * Check if property not in DB.
	 * To change error messages use UniqueInDbValidator.findByProperty.{property}
	 *
     */
	public static class UniqueInDbValidator extends DbValidator {
		private static final long serialVersionUID = 1L;

		private Dao<?> dao;
		private String property;

		public UniqueInDbValidator(Dao<?> dao, String property) {
			this.dao = dao;
			this.property = property;
		}

		@Override
		public void validate(IValidatable<String> validatable) {
			SimpleExpression expression =
					Restrictions.eq(property, validatable.getValue());
			Object user = dao.getCriteriaUnique(expression);
			if(user != null) {
				validatable.error(new ValidationError(this, "findByProperty." + property));
			}
		}
	}

	public static DbValidator findByProperty(Dao<?> dao, String property) {
		return new UniqueInDbValidator(dao, property);
	}
}
