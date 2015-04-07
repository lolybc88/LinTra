
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class Manifest  implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			ManifestAttribute mainAttributes; Boolean mainAttributesIsComposed = true;
			
			ManifestEntry entryAttributes; Boolean entryAttributesIsComposed = true;
			
			
			public Manifest(){ }
			
			
			public Manifest(
				String id,				
				
				ManifestAttribute mainAttributes,				ManifestEntry entryAttributes ){
				
				super(				);
				
				this.id = id;
				
				
				
				this.mainAttributes = mainAttributes ;
				this.entryAttributes = entryAttributes ;
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
			
			
			
			
			
			public void setMainAttributes(ManifestAttribute mainAttributes) {
				this.mainAttributes = mainAttributes;
			}
				
			public ManifestAttribute getMainAttributes() {
				return mainAttributes;
			}
			
			public void setEntryAttributes(ManifestEntry entryAttributes) {
				this.entryAttributes = entryAttributes;
			}
				
			public ManifestEntry getEntryAttributes() {
				return entryAttributes;
			}
			
		}
	