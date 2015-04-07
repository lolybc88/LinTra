
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public abstract class NamespaceAccess  extends ASTNode implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			
			
			
			
			
			
			public NamespaceAccess(){ }
			
			
			public NamespaceAccess(
				
				
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				
				
				
				
			}
			
			
			
			
			
			
			
		}
	