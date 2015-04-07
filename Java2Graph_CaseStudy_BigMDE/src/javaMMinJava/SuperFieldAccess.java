
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class SuperFieldAccess  extends AbstractTypeQualifiedExpression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			SingleVariableAccess field; Boolean fieldIsComposed = true;
			
			
			public SuperFieldAccess(){ }
			
			
			public SuperFieldAccess(
				String id,				
				
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				TypeAccess qualifier,				SingleVariableAccess field ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
				,				qualifier
);
				
				this.id = id;
				
				
				
				this.field = field ;
			}
			
			
			
			public String getId() {
   				return id;
			}

			public void setId(String id) {
   				this.id = id;
			}
			
			public String getTrgId() {
   				return trgId;
			}

			public void setTrgId(String trgId) {
   				this.trgId = trgId;
			}
			
			
			
			
			
			public void setField(SingleVariableAccess field) {
				this.field = field;
			}
				
			public SingleVariableAccess getField() {
				return field;
			}
			
		}
	