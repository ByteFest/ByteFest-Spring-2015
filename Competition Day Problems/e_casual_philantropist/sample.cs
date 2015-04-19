        public static int CasualPhilanthropist()
        {
            //input
            int[] groceries = new int[] { 1, 4, 2, 7, 4, 8 };
            //int[] groceries = new int[] { 2, 4, 3, 8 };
            //int[] groceries = new int[] { 5 };
            //int[] groceries = new int[] { 200, 3 };
            //int[] groceries = new int[] { 100, 33, 4, 55, 10, 6, 10, 10, 9, 2, 7 };

            //init output to 0
            int tip = 0;

            List<List<int>> groups = new List<List<int>>();
            for (int i = 0; i < groceries.Length; i++)
            {
                int group = i / 3;
                if (i % 3 == 0)
                {
                    groups.Add(new List<int>());
                }
                groups[group].Add(groceries[i]);
            }

            foreach (List<int> group in groups)
            {
                int maxTip = 0;
                int len = group.Count - 1;
                for (int i = 0; i < group.Count; i++)
                {
                    if (group[i] % 3 == 0)
                    {
                        maxTip = 0;
                        if (i < len && group[i + 1] % 2 == 0)
                        {
                            maxTip = group[i + 1] / 2;
                            //skip next
                            i++;
                        }
                        else if (i < len && group[i + 1] % 2 != 0)
                        {
                            i = len + 1;
                        }
                    }
                    else if (group[i] % 2 == 0)
                    {
                        maxTip = group[i] / 2;
                        if (i < len && group[i + 1] < group[i] && group[i + 1] % 2 == 0 && group[i + 1] % 3 != 0)
                        {
                            maxTip = group[i + 1] / 2;
                            //skip next
                            i++;
                        }
                        else if (i < len && group[i + 1] > group[i] && group[i + 1] % 2 == 0 && group[i + 1] % 3 != 0)
                        {
                            i++;
                        }
                    }
                }
                if (maxTip > tip)
                {
                    tip = maxTip;
                }
            }
            return tip;
        }