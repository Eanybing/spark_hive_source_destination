/*
 * Copyright (c) 2016 Villu Ruusmann
 *
 * This file is part of JPMML-Spark
 *
 * JPMML-Spark is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Spark is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Spark.  If not, see <http://www.gnu.org/licenses/>.
 */
package spark;

import org.apache.spark.sql.types.StructField;
import org.dmg.pmml.FieldName;
import org.jpmml.evaluator.Evaluator;

import java.io.Serializable;

abstract
class ColumnProducer implements Serializable {

	private FieldName fieldName = null;

	private String columnName = null;


	ColumnProducer(FieldName fieldName, String columnName){
		setFieldName(fieldName);
		setColumnName(columnName);
	}

	abstract
	public StructField init(Evaluator evaluator);

	abstract
	public Object format(Object value);

	public FieldName getFieldName(){
		return this.fieldName;
	}

	private void setFieldName(FieldName fieldName){
		this.fieldName = fieldName;
	}

	public String getColumnName(){
		return this.columnName;
	}

	private void setColumnName(String columnName){

		if(columnName == null){
			throw new IllegalArgumentException();
		}

		this.columnName = columnName;
	}
}